import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Removes the symbols that happen at the end of all tokens.
public class TokenCleaner {
    public static void main(String[] args) {
        char[] symbols = { ',', ';', '"', ':', '.', '!', '?', '(', ')', '-' };

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            int len = word.length();
            char endChar = word.charAt(len - 1);

            // Remove the last character if it is a symbol.
            for (int i = 0; i < symbols.length; i++) {
                if (endChar == symbols[i]) {
                    word = word.substring(0, len - 1);
                }
            }

            StdOut.println(word);
        }
    }
}
