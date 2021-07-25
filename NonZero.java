import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class NonZero {
    public static void main(String[] args) {

        In in = new In(args[0]);
        double[] freq = in.readAllDoubles();

        In in2 = new In(args[1]);
        String[] allwords = in2.readAllStrings();

        ST<String, Double> words = new ST<String, Double>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                words.put(allwords[i], freq[i]);
            }
        }

        for (String item : words) {
            StdOut.print(item);
            StdOut.print(" ");
            StdOut.print(words.get(item));
            StdOut.println();
        }
    }
}
