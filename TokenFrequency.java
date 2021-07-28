import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class TokenFrequency {
    /**
     * Reads the input document and creates a frequency table for the given vocabulary list.
     * Replaces: TokenFrequencyGenerator.java.
     * 
     * Includes the option to remove zero frequencies.
     * Replaces: NonZero.java.
     */
    public static void main(String[] args) {
        boolean REMOVE_ZERO_FREQUENCIES = false;

        // Create a term frequency (tf) symbol table of tokens (key) to frequencies (value).
        ST<String, Integer> tf = new ST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String token = StdIn.readString();
            tf.put(token, tf.contains(token) ? tf.get(token) + 1 : 1);
        }

        // Create a frequency table of counts whose positions correspond to the given bag of words.
        List<String> bow = Arrays.asList(new In(args[0]).readAllStrings());
        int[] frequency = new int[bow.size()];
        for (String token : tf) {
            int t = bow.indexOf(token);
            frequency[t] = tf.get(token);
        }

        // Write the resulting frequencies to standard output.
        for (int i = 0; i < frequency.length; i++) {
            if (REMOVE_ZERO_FREQUENCIES) {
                if (frequency[i] != 0) {
                    StdOut.println(frequency[i] + "\t\t" + bow.get(i));
                }
            } else {
                StdOut.println(frequency[i]);
            }
        }
    }
}