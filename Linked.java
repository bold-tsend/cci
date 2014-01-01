public class Linked {
    
    Linked next = null; 
    int data; 

    public Linked(int data) {
        this.data = data;
    }

    void dump() {
        System.out.println("Dump list:"); 

        Linked cur = this; 
        while(cur != null) {
            System.out.println(cur.data);
            cur = cur.next();
        }

        System.out.println("---"); 
    }

    public boolean equals(Object test) {
        // Assume that no class cast exception occurs
        Linked ltest = (Linked)test;
        return ltest.data == this.data;
    }

    Linked append(int data) {
        Linked scan = this; 
        while(scan.next() != null) {
            scan = scan.next();
        }

        Linked newLinked = new Linked(data); 
        scan.next = newLinked; 
        return scan; 
    }

    Linked next() {
        return this.next; 
    }

    Linked deleteNext() {
        if(next == null)
            return null; 

        Linked newNext = next.next(); 
        next = newNext; 
        return next; 
    }
}
