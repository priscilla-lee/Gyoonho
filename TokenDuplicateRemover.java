import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

// removes duplicate tokens from a document.
public class TokenDuplicateRemover {
    public static void main(String[] args) {

        String word;
        Stack<String> all_words;
        String[] vocabs;
        int vocabs_total_num;

        // read in all tokens including the duplicates.
        all_words = new Stack<String>();
        while (!StdIn.isEmpty()) {
            word = StdIn.readString();
            all_words.push(word);
        }

        vocabs_total_num = all_words.size();
        vocabs = new String[vocabs_total_num];

        for (int i = 0; i < vocabs_total_num; i++) {
            vocabs[i] = all_words.pop();
        }

        // sort the tokens including the duplicates.
        Arrays.sort(vocabs);

        // create an that will hold distinct tokens.
        String[] temp = new String[vocabs.length];
        int j = 0;

        // count the amount of same items
        for (int i = 0; i < vocabs.length - 1; i++) {
            if (!vocabs[i].equals(vocabs[i + 1])) {
                temp[j] = vocabs[i];
                j++;
            }
        }

        // count the amount of NULL items.
        int null_item_count = 0;
        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] == null) {
                null_item_count++;
            }
        }

        int sorted_without_num = temp.length - null_item_count;
        String[] final_result = new String[sorted_without_num];

        // copy over only the distinct elements without the null count.
        int k = 0;
        while (temp[k] != null) {
            final_result[k] = temp[k];
            k++;
        }

        // write to standard output.
        for (int l = 0; l < sorted_without_num; l++) {
            StdOut.println(final_result[l]);
        }

    }
}




