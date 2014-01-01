public class Substring {

    public Substring() {
        String s1 = "waterbottle"; 

        // s2 is a rotation of s1
        String s2 = "bottlewater"; 

        // Use isSubstring to check if s2 is a rotation of s1
        // Assume a rotation splits s1 into two parts xy
        // s1 = xy
        // Then s2 has to be the rotation of both substrings
        // s2 = yx
        // Now s1s1 = xyxy
        // It is clear that s2 = ys is substring of s1s1
        
        // Build string s1s1
        String s1s1 = s1 + s1; 

        // Check if both strings are of equal length > zero
        if(s1.length() == s2.length() && s1.length() > 0) {
            // Use isSubstring to test rotation
            System.out.println("s2 rotation of s1: " + isSubstring(s2, s1s1));
        } else {
            // Different lengthes or length == 0 - so no rotation
            System.out.println("s2 rotation of s1: false"); 
        }
    }
    
    boolean isSubstring(String substring, String of) {
        return of.indexOf(substring) >= 0; 
    }

    public static void main(String arg[]) {
        new Substring(); 
    }
}
