import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Removes the symbols among the tokens.
public class TokenSymbolRemover {
    public static void main(String[] args) {
        char[] symbols = { ',', ';', '"', ':', '.', '!', '?', '(', ')', '-' };

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            char firstChar = word.charAt(0);

            // Omit the word if its first character is a token.
            for (int i = 0; i < symbols.length; i++) {
                if (firstChar == symbols[i]) {
                    word = " ";
                }
            }

            StdOut.println(word);
        }
    }
}
