public class AdditionFwd {

    public AdditionFwd() {
        // Number a
        Linked a = new Linked(6);
        a.append(1);
        a.append(7);

        // Number b
        Linked b = new Linked(2);
        b.append(9);
        b.append(5); 

        // Dump both numbers
        a.dump();
        b.dump();

        // Perform addition of both numbers
        Linked result = add(a, b);

        // Dump result
        result.dump(); 
    }

    Linked reverse(Linked i) {
        // Pointer to reversed linked list 
        Linked r = null; 

        while(i != null) {
            // Backup next pointer of input number 
            Linked t = i.next(); 

            // Redirect next pointer of input number
            i.next = r; 

            // Move result pointer to new start element
            r = i; 

            // Move to next input number
            i = t; 
        }

        return r; 
    }
    
    Linked add(Linked a, Linked b) {
        // Reverse input numbers
        a = reverse(a); 
        b = reverse(b); 

        // Linked list of result value
        Linked r = null; 

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
            if(r == null)
                r = new Linked(s);
            else
                r.append(s);

            // Move both list pointers
            a = a.next();
            b = b.next(); 
        }

        // Reverse output number again
        r = reverse(r); 
        
        return r; 
    }
    
    public static void main(String arg[]) {
        new AdditionFwd(); 
    }
}
