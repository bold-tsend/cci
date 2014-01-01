public class Palindrom {

    public Palindrom() {
        // Build a new linked list for testing
        Linked linked = new Linked(0); 
        linked.append(5);
        linked.append(2);
        linked.append(3);
        linked.append(3);
        linked.append(2);
        linked.append(1);
        linked.append(0);

        // Dump list
        linked.dump(); 

        boolean test = isPalindrom(linked); 
        System.out.println("Is palindom: " + test); 
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

    Linked copy(Linked l) {
        Linked c = null;
        for(Linked i=l; i!=null; i=i.next()) {
            if(c == null)
                c = new Linked(i.data);
            else
                c.append(i.data);
        }
        return c;
    }

    boolean isPalindrom(Linked linked) {
        Linked copy = copy(linked); 
        Linked rev = reverse(linked); 

        while(copy != null && rev != null) {
            if(copy.data != rev.data)
                return false;

            copy = copy.next();
            rev = rev.next(); 
        }

        return true; 
    }

    public static void main(String arg[]) {
        new Palindrom(); 
    }
}
