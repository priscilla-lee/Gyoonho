import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tokens {
    private static final List<Character> SYMBOLS =
       Arrays.asList(',', ';', '"', ':', '.', '!', '?', '(', ')', '-');

    private static boolean isSymbol(char c) {
        return SYMBOLS.contains(c);
    }

    private static String trimEndingSymbol(String s) {
        int len = s.length();
        return isSymbol(s.charAt(len - 1)) ? s.substring(0, len - 1) : s;
    }

    /**
     * Removes tokens that start with a symbol.
     * Replaces: TokenSymbolRemover.java.
     * 
     * And removes the symbols that happen at the end of all tokens.
     * Replaces: TokenCleaner.java.
     */
    private static List<String> removeSymbols(List<String> tokens) {
        return tokens
            .stream()
            // Filter out the the word if its first character is a token.
            .filter(token -> !isSymbol(token.charAt(0)))
            // Remove the last character if it is a symbol.
            .map(Tokens::trimEndingSymbol)
            .collect(Collectors.toList());
    }

    /**
     * Removes duplicates from the list of tokens and returns a sorted list of distinct tokens.
     * Replaces: TokenDuplicateRemover.java.
     */
    private static List<String> dedupe(List<String> tokens) {
        List<String> distinct = tokens.stream().distinct().collect(Collectors.toList());

        // Sort the distinct tokens in ascending alphabetical order.
        Collections.sort(distinct);
        return distinct;
    }

    /**
     * Generates symbol-free tokens from the input document. De-duplicating is an option.
     * Replaces: TokenGenerator.java.
     */
    public static void main(String[] args) {
        boolean REMOVE_DUPLICATES = false;

        // Read tokens from the document and remove symbols.
        List<String> tokens = Arrays.asList(StdIn.readAllStrings());
        List<String> symbolFree = removeSymbols(tokens);

        // Optionally de-duplicate and sort tokens before writing to standard output.
        List<String> result = REMOVE_DUPLICATES ? dedupe(symbolFree) : symbolFree;
        StdOut.println(String.join("\n", result));
    }
}
