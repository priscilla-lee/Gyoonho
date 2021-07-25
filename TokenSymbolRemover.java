import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// removes the symbols among the tokens.
public class TokenSymbolRemover {
    public static void main(String[] args) {
        String word;
        char first_char;
        char[] symbols = { ',', ';', '"', ':', '.', '!', '?', '(', ')', '-' };

        while (!StdIn.isEmpty()) {

            word = StdIn.readString();
            first_char = word.charAt(0);

            // check if the character is a token.
            for (int i = 0; i < symbols.length; i++) {
                if (first_char == symbols[i]) {
                    word = " ";
                }
            }
            // writes to standard output.
            StdOut.println(word);
        }
    }
}
