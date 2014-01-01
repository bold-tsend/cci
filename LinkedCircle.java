public class LinkedCircle {

    public LinkedCircle() {
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
        // a->b->c -x-> d->e->b
        // clear        scan    field

        // Points to the start of the scan field
        Linked scanLinked = linked.next();

        // Points to the tail of the clear field
        Linked clear = linked; 

        // Remove pointer between clear and scan field
        clear.next = null;  
        
        // Iterate with scanLinked and clear (Assume no cycle)
        while(scanLinked != null) {
            // Check if scanned node of scan field is in the clear field
            for(Linked scanClear=linked; scanClear != null; scanClear = scanClear.next()) {
                // Cycle detection
                if(scanClear == scanLinked)
                    return scanClear; 
            } 

            // Node is clear, add it to clear field
            clear.next = scanLinked; 
            clear = scanLinked;

            // Check next node of scan field
            scanLinked = scanLinked.next(); 

            // Remove pointer between clear nad scan field
            clear.next = null; 
        }

        // No cycle found
        return null; 
    }

    public static void main(String arg[]) {
        new LinkedCircle(); 
    }
}
