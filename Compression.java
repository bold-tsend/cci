public class Compression {

    public Compression() {
        String text = "Helllooooo WWWoorld !!!!!"; 
        char[] ct = text.toCharArray(); 
        int i = 0; 
        int r = 0; 
        while(r < ct.length) {
            // Set scan pointer to read position
            int sp = r; 
            
            // Scan length
            while(sp < ct.length && ct[sp] == ct[r])
                sp++; 

            // Get number of repeating chars as character array
            int count = sp - r; 
            char[] cCount= toChar(count); 

            // Replace only if more efficient in terms of length
            // +1 accounts for character after count, e.g. 3s
            if(cCount.length + 1 < count) {
                ct[i++] = ct[r];
                System.arraycopy(cCount, 0, ct, i, cCount.length); 
                i += cCount.length; 
            } else {
                // Copy over repeating chars
                System.arraycopy(ct, r, ct, i, count);
                i += count;
            }

            // In all cases (compression or no compression) move cursor
            r += count;
        }

        // Trim string for new size
        String result = new String(ct); 
        result = result.substring(0, i); 

        System.out.println("Result compressed: " + result); 
    }

    char[] toChar(int i) {
        String s = Integer.toString(i);
        return s.toCharArray(); 
    }

    public static void main(String arg[]) {
        new Compression(); 
    }
}
