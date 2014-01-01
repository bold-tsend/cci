public class KLast {

    public KLast() {
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

        // Find kth last element (if there is one)
        int k = 7;
        Linked last = findLast(k, linked);
        if(last != null)
            System.out.println("Last " + k + "th element: " + last.data); 
        else
            System.out.println("List is too short"); 

        // Tests
        // - Empty list
        // - List with one element
        // - k is list length (first element gets selected)
        // - k = 0
    }

    Linked findLast(int k, Linked linked) {
        // How many moves were done without moving hang pointer
        int moves = 0; 

        // Hanging pointer runs k moves behind scan pointer
        Linked hangp = linked;

        // Scan pointer
        Linked scanp = linked;

        // Scan until end of list is reached
        while(scanp.next() != null) {
            scanp = scanp.next(); 

            // How often was th escan pointer moved
            if(moves >= k) {
                // Moved at least k times - move hang pointer too
                // hang pointer moves in a distance of k elements to scan pointer
                hangp = hangp.next(); 
            } else {
                // Increment moves if distance hang and scan pointer is < k
                moves++;
            }
        }

        // Check if distance is right
        // Linked list doesn't have a length information
        if(moves >= k)
            return hangp; 

        return null;
    }

    public static void main(String arg[]) {
        new KLast(); 
    }
}
