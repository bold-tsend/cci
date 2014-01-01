public class SpaceReplace {
    
    public SpaceReplace() {
        String t = "Hello World  this is a simple test with more chars !!!!                        "; 
        char ct[] = t.toCharArray(); 
        int i = ct.length - 1; 
        int r = i; 

        // Scan start read position
        while(ct[r] == ' ') {
            r--; 
        }

        // Read and copy chars
        while(r >= 0) {
            if(i > r) {
                System.out.println("ERROR: Read pointer must not be behind insert pointer"); 
                System.out.println("Reason: Not enough space chars at end of string"); 
                break; 
            }

            if(ct[r] == ' ' ) {
                if(i < 2) {
                    System.out.println("ERROR: No space left to insert %20"); 
                    System.out.println("Reason: Not enough space chars at end of string"); 
                }
                ct[i--] = '0';
                ct[i--] = '2';
                ct[i--] = '%';
            } else {
                ct[i--] = ct[r];
            }

            r--; 
        }

        String result = new String(ct);
        result = result.substring(i + 1); 
        System.out.println("Result string: " + result); 
    }

    public static void main(String arg[]) {
        new SpaceReplace();
    }
}
