public class Reverse {

    public Reverse() {
        // Char string of text
        String text = "HelloWorld!"; 
        char[] ctext = text.toCharArray();

        // Length of string
        int l = ctext.length; 

        // Pointers
        int e = l - 1;
        int s = 0; 

        while(e > s) {
            char temp = ctext[e]; 
            ctext[e] = ctext[s];
            ctext[s] = temp;

            // Move pointers
            e--;
            s++; 
        }

        System.out.println(new String(ctext));
    }


    public static void main(String arg[]) {
        new Reverse(); 
    }
}
