import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// tokenizes a document.
public class TokenGenerator {

    public static void main(String[] args) {
        String word;

        // read from standard input, and divide the document into tokens.
        while (!StdIn.isEmpty()) {
            word = StdIn.readString();
            StdOut.println(word);
        }
    }
}
