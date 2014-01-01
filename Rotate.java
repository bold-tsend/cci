import java.util.Arrays;

public class Rotate {

    public Rotate() {
        int[][] m = {
            {1,3,4},
            {4,6,7},
            {7,3,7}
        };

        // Size of the matrix
        int n = m.length; 

        // Index of the last element in the matrix
        int ni = n - 1;

        // Print matrix
        System.out.println(Arrays.deepToString(m)); 

        // Go over all layers in matrix
        for(int l=0; l<n/2; l++) {

            // Size of submatrix nnxnn
            int nn = (n-2*l);
            
            // Gover all element in each of the four segments
            for(int i=0; i<(nn - 1); i++) {

                // Copy rotation for current element of segment
                int tmp = m[l][l+i];
                m[l][l+i] = m[ni-l-i][l];
                m[ni-l-i][l] = m[ni-l][ni-l-i];
                m[ni-l][ni-l-i] = m[l+i][ni-l];
                m[l+i][ni-l] = tmp; 
            }
        }

        // Print result matrix
        System.out.println(Arrays.deepToString(m));
    }

    public static void main(String arg[]) {
        new Rotate();
    }
}

