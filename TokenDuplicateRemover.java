import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

// Removes duplicate tokens from a document.
public class TokenDuplicateRemover {
    public static void main(String[] args) {
        // Read all tokens (including the duplicates) into a stack.
        Stack<String> allwords = new Stack<String>();
        while (!StdIn.isEmpty()) {
            allwords.push(StdIn.readString());
        }

        // Transfer all tokens into a sorted array.
        String[] sorted = new String[allwords.size()];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = allwords.pop();
        }
        Arrays.sort(sorted);

        // Write distinct tokens to standard output.
        StdOut.println(sorted[0]);
        for (int i = 1; i < sorted.length; i++) {
            if (!sorted[i].equals(sorted[i-1])) {
                // Bug in original code: Prints null instead of the last distinct token.
                // Fix in this code: Prints out the last distinct token instead of null.
                StdOut.println(sorted[i]);
            }
        }
    }
}




