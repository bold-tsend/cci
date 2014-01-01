public class Permutation {

    public Permutation() {
        // Both strings to check if s2 is a permutation of s1
        String s1 = "hello"; 
        String s2 = "oelhl"; 

        // Get char counts for each string 
        int[] countsS1 = counts(s1); 
        int[] countsS2 = counts(s2); 

        // Compare both char counts
        for(int i=0; i<countsS1.length; i++) {
            // No permutation check
            if(countsS1[i] != countsS2[i]) {
                System.out.println("No permutation"); 
                return; 
            }
        }

        // Permutation found
        System.out.println("Permutation found"); 
    }

    int[] counts(String s) {
        // For each 256 ASCII chars there is one counter
        int[] counts = new int[256];
        
        // Increment counter for each ASCII char
        for(int i=0; i<s.length(); i++) {
            // Counter increment
            counts[s.charAt(i)]++;
        }

        return counts; 
    }
    
    public static void main(String arg[]) {
        new Permutation(); 
    }
}
