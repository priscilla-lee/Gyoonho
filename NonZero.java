import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class NonZero {
    public static void main(String[] args) {
        double[] frequencies = new In(args[0]).readAllDoubles();
        String[] words = new In(args[1]).readAllStrings();

        // Print all nonzero word-frequency pairs.
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] != 0) {
                StdOut.println(words[i] + " " + frequencies[i]);
            }
        }
    }
}
