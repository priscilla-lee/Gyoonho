import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class IdfMatrix {
    public static void main(String[] args) {
        int D = args.length;
        int V = new In(args[0]).readAllDoubles().length;

        // Read in term frequencies (tf).
        double[][] tf = new double[D][V];
        for (int d = 0; d < D; d++) {
            tf[d] = new In(args[d]).readAllDoubles();
        }

        // Count the number of documents that contain each vocab.
        int[] nonZero = new int[V];
        for (int v = 0; v < V; v++) {
            for (int d = 0; d < D; d++) {
                if (tf[d][v] != 0) {
                    nonZero[v] += 1;
                }
            }
        }

        // Compute term frequency - inverse document frequencies (tf-idf) and write to standard output.
        for (int d = 0; d < D; d++) {
            for (int v = 0; v < V; v++) {
                StdOut.print(tf[d][v] * Math.log(1.0 * D / (1 + nonZero[v])) + ",");
            }
            StdOut.print("\n");
        }
    }
}

