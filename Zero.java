import java.util.Arrays;

public class Zero {

    public Zero() {
        int[][] m = {
            {1,3,4},
            {4,6,7},
            {8,0,7}
        };

        // Print initial matrix
        System.out.println(Arrays.deepToString(m)); 

        // Markers for column and row
        boolean[] rowmarker = new boolean[m[0].length];
        boolean[] colmarker = new boolean[m.length];

        // Find all 0s and updated row/col markers
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++) {
                if(m[i][j] == 0) {
                    rowmarker[i] = true;
                    colmarker[j] = true; 
                }
            }
        }

        // Replace all rows with 0 according to row markers
        for(int i=0; i<rowmarker.length; i++) {
            if(rowmarker[i])
                for(int j=0; j<m[i].length; j++)
                    m[i][j] = 0; 
        }

        // Replace all cols with 0 according to col markers
        for(int j=0; j<colmarker.length; j++) {
            if(colmarker[j])
                for(int i=0; i<m.length; i++)
                    m[i][j] = 0; 
        }

        // Print result matrix
        System.out.println(Arrays.deepToString(m)); 
    }

    public static void main(String arg[]) {
        new Zero(); 
    }
}
