public class LinkedCircleEfficient {

    public LinkedCircleEfficient() {
        // Build a new linked list for testing
        Linked linked = new Linked(1); 
        linked.append(2);
        linked.append(3);
        Linked circleTarget = linked.append(4);
        linked.append(5);
        linked.append(6);
        Linked circleSource = linked.append(7);

        // Add circle (corrupt list)
        circleSource.next = circleTarget;

        // Linked list has a circle (dump is not designed for circes)

        // Find circle root
        Linked root = findCircleRoot(linked); 
        if(root == null)
            System.out.println("No circle found"); 
        else
            System.out.println("Circle root: " + root.data); 
    }

    Linked findCircleRoot(Linked linked) {
        // Use slow and fast pointer to go through linked list
        Linked slow = linked;
        Linked fast = linked; 

        // Find collision of fast and slow pointer (indicates cycle)
        while(slow != null && fast != null) {
            // Slow moves one and fast two elements per cycle
            slow = slow.next();
            fast = fast.next().next(); 

            // Collission found
            if(slow == fast)
                break; 
        }

        // Check if a cycle was found
        if(slow == fast && slow != null)
            slow = linked;
        else
            return null; 
    
        // Find start element of cycle
        while(slow != fast) {
            slow = slow.next();
            fast = fast.next(); 
        }
        
        return slow;
    }

    public static void main(String arg[]) {
        new LinkedCircleEfficient();
    }
}
