import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class idf_matrix {
    public static void main(String[] args) {

        double[][] tf = new double[29][251715];

        for (int i = 0; i < 29; i++) {
            In in = new In(args[i]);
            double[] temp = in.readAllDoubles();
            for (int j = 0; j < 251715; j++) {
                tf[i][j] = temp[j];
            }
        }

        // test
        // for (int k = 0; k < 29; k++) {
        //     for (int l = 0; l < 251715; l++) {
        //         StdOut.print(tf_idf[k][l]);
        //         StdOut.print();
        //     }
        //     StdOut.println();
        // }

        int[] non_zero = new int[251715];
        int count = 0;

        for (int col = 0; col < 251715; col++) {
            for (int row = 0; row < 29; row++) {
                if (tf[row][col] != 0)
                    count++;
            }
            non_zero[col] = count;
            count = 0;
        }

        double[][] tf_idf = new double[29][251715];

        for (int row = 0; row < 29; row++) {
            for (int col = 0; col < 251715; col++) {
                tf_idf[row][col] = tf[row][col] * Math.log(29.0 / (1 + non_zero[col]));
            }
        }

        for (int row = 0; row < 29; row++) {
            for (int col = 0; col < 251715; col++) {
                StdOut.print(tf_idf[row][col]);
                StdOut.print(",");
            }
            StdOut.print("\n");
        }
    }
}

