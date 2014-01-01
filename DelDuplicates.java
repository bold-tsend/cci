public class DelDuplicates {

    public DelDuplicates() {
        // Create new linked list
        Linked linked = new Linked(33); 
        linked.append(4);
        linked.append(56);
        linked.append(34);
        linked.append(4); 
        linked.append(4); 

        linked.dump();
        removeDuplicates(linked);
        linked.dump(); 
    }

    void removeDuplicates(Linked linked) {
        Linked p = linked; 
        while(p != null) {
            Linked pfp = p;
            Linked fp = p.next(); 

            while(fp != null) {
                if(fp.equals(p)) {
                    pfp.deleteNext(); 
                    fp = pfp.next();     
                } else {
                    pfp = fp; 
                    fp = fp.next(); 
                }
            }

            p = p.next();
        }
    }

    public static void main(String arg[]) {
        new DelDuplicates(); 
    }
}
