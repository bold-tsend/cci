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

    /**
     * Slow pointer moves one elements and the fast one two
     * After k elements slow pointer moves circle start s
     * Faster poinster has moved 2k elements
     * Of the 2k elements 2k - k = k elements in cycle
     * Fast pointer has cycle position F = k % S (S elements in cycle)
     * Faster pointer is S - F elements behind slow pointer and catches up with one element per unit of time
     * After S - F additional steps slow and fast pointer collide
     * So collission happens S - F steps after element or F steps before start
     * --- collision detected -> cycle detected -> where is cycle start?
     * From collission F elements to start
     * F = k % S -> k = F + M * S (with M natural positive number)
     * Because of cycle M * S can be ignored
     * Moving both pointers at normal speed (one element at a unit of time) for k
     * elements moves fast pointer to cycle start
     * We know that slow pointer moves k elements from list start to cycle start
     * So, slow pointer is set to list start and fast pointer is left as it is
     * both pointers are moved until they collade
     * Fast pointer has moved F steps equal k steps and slow pointer has moved k steps
     * as well
     * Hence, the collission happens at the cycle start. 
     */
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
