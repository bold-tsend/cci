class Unique {

    public static void main(String arg[]) {
        new Unique();
    }

    public Unique() {
        String input= "abcdefg"; 
        boolean[] test = new boolean[256]; 
        for(char c : input.toCharArray()) {
            if(test[c] == true) {
                System.out.println("Duplicate found: " + c);
                return; 
            } 
            test[c] = true; 
            
        }

        System.out.println("Everything OK no duplicates found!"); 
    }
}
