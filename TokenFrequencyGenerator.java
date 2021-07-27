import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Creates a TF table for a given document.
public class TokenFrequencyGenerator {
    public static void main(String[] args) {
        // Create a symbol table of tokens (key) to frequencies (value).
        // Bug in original code: Doesn't count the last token if it only occurs once.
        // Fix in this code: Counts the last token, even if it only occurs once.
        ST<String, Integer> frequencies = new ST<String, Integer>();
        while (!StdIn.isEmpty()) {
            String token = StdIn.readString();
            if (frequencies.contains(token)) {
                frequencies.put(token, frequencies.get(token) + 1);
            } else {
                frequencies.put(token, 1);
            }
        }

        // Create a frequency table of counts whose positions correspond to the given bag of words.
        String[] bow = new In(args[0]).readAllStrings();
        int[] frequencyTable = new int[bow.length];

        for (String token : frequencies) {
            for (int i = 0; i < bow.length; i++) {
                if (bow[i].equals(token)) {
                    frequencyTable[i] = frequencies.get(token);
                    break;
                }
            }
        }

        // Write the resulting frequency table to standard output.
        for (int i = 0; i < frequencyTable.length; i++) {
            StdOut.println(frequencyTable[i]);
        }
    }
}

