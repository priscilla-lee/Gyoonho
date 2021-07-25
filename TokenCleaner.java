import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// removes the symbols that happen at the end of all tokens.
public class TokenCleaner {

    public static void main(String[] args) {
        String word;
        int word_length;
        char end_char;
        char[] symbols = { ',', ';', '"', ':', '.', '!', '?', '(', ')', '-' };

        // read from standard input
        while (!StdIn.isEmpty()) {

            word = StdIn.readString();
            word_length = word.length();
            end_char = word.charAt(word_length - 1);

            // check the last character and clean it if it is a symbol
            for (int i = 0; i < symbols.length; i++) {
                if (end_char == symbols[i]) {
                    word = word.substring(0, word_length - 1);
                }
            }

            // write to standard output.
            StdOut.println(word);
        }
    }
}
