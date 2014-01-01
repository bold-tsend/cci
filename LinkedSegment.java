public class LinkedSegment {

    public LinkedSegment() {
        // Build a new linked list for testing
        Linked linked = new Linked(0); 
        linked.append(4);
        linked.append(3);
        linked.append(1);
        linked.append(8);
        linked.append(30);
        linked.append(20);
        linked.append(14);

        // Dump it to verify results
        linked.dump();

        // Segment linked list with x
        int x = 7; 
        linked = segment(x, linked); 

        // Dump result list
        System.out.println("Split is set at: " + x); 
        linked.dump();
    }

    Linked segment(int x, Linked l) {
        // Pointer for sublist of smaller elements
        Linked smaller = null;

        // Points to the tail of the smaller sublist
        // Used to concat smaller and larger sublist in the end
        Linked smallerTail = null; 

        // Pointer for sublist of larger elements
        Linked larger = null;

        // Go over all list elements
        while(l != null) {
            // Store reference to the next element
            Linked bufNext = l.next(); 
            
            // Decide on which sublist
            if(l.data < x) {
                // Update tail pointer the first time
                if(smaller == null)
                    smallerTail = l;

                // Insert node at the beginning of the sublist
                l.next = smaller; 
                smaller = l; 
            } else {
                // Insert node at the beginning of the sublist
                l.next = larger; 
                larger = l; 
            }

            // Next node
            l = bufNext; 
        }

        // Concat smaller and larger sublists
        smallerTail.next = larger; 
            
        return smaller; 
    }

    public static void main(String arg[]) {
        new LinkedSegment(); 
    }
}
