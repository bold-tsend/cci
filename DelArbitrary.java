public class DelArbitrary {

    public DelArbitrary() {
        // Build a new linked list for testing
        Linked linked = new Linked(0); 
        linked.append(4);
        linked.append(3);
        linked.append(1);
        linked.append(8);
        linked.append(30);
        Linked toDel = linked.append(20);
        linked.append(14);

        // Dump it to verify results
        linked.dump();

        // Remove toDel node
        boolean status = delete(toDel);
        System.out.println("Status: " + status); 

        // Dump resluting list
        linked.dump(); 

        // Attention: This approach might lead to stale pointers 
        // in application code that referrs the next node that gets removed!
    }

    boolean delete(Linked toDel) {
        // toDel cannot be removed itself because prev pointer and
        // the head pointer of the linked list are missing
        // Solution: Copy over all data from next() and removeNext()
        
        Linked next = toDel.next(); 
        if(next == null) {
            System.out.println("Unable to remove node - no next pointer for last node");
            // Possible solution: Mark node as deleted
            return false; 
        }

        System.out.println("Removing node with value: " + toDel.data); 
        toDel.data = next.data; 
        toDel.deleteNext(); 
        return true; 
    }
    
    public static void main(String arg[]) {
        new DelArbitrary(); 
    }
}
