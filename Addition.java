public class Addition {

    public Addition() {
        // Number a
        Linked a = new Linked(7);
        a.append(1);
        a.append(6);

        // Number b
        Linked b = new Linked(5);
        b.append(9);
        b.append(2); 

        // Dump both numbers
        a.dump();
        b.dump();

        // Perform addition of both numbers
        Linked result = add(a, b);

        // Dump result
        result.dump(); 
    }

    Linked add(Linked a, Linked b) {
        // Initialize with dummy 0 - gets removed in the end 
        // Increase code readability by removing one if statement
        Linked r = new Linked(0); 

        // Carry flag
        int c = 0; 

        // Perform addition loop
        while(a != null || b != null) {
            // Get values
            int va = 0, vb = 0; 
            if(a != null) va = a.data;
            if(b != null) vb = b.data;

            // Perform addition and carry extraction
            int s = va + vb + c;
            c = s / 10; 
            s = s % 10; 

            // Append result to result list 
            r.append(s);

            // Move both list pointers
            a = a.next();
            b = b.next(); 
        }

        // Remove dummy 0
        r = r.next(); 

        return r; 
    }
    
    public static void main(String arg[]) {
        new Addition(); 
    }
}
