import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

// creates a TF table for a given document.
public class TokenFrequencyGenerator {
    public static void main(String[] args) {

        // create a bag of words.
        In in = new In(args[0]);
        String[] bow = in.readAllStrings();

        String word;
        Stack<String> all_words;
        String[] vocabs;
        int vocabs_total_num;

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
        Arrays.sort(vocabs);

        // vocabs contains the sorted tokens of Rauber
        int vocab_index = 0;
        int count = 1;

        // symbol table consisting of key - Token, and value - frequency.
        ST<String, Integer> word_frequency = new ST<String, Integer>();

        while (vocab_index < vocabs.length - 1) {
            while (vocabs[vocab_index].equals(vocabs[vocab_index + 1])) {
                count++;
                if (vocab_index == vocabs.length - 2)
                    break;
                vocab_index++;
            }
            word_frequency.put(vocabs[vocab_index], count);
            count = 1;
            vocab_index++;
        }


        int num_appearance;
        int index = 0;
        String token;

        int[] frequency_table = new int[bow.length];

        // using each item in the symbol table, update the frequency table.
        for (String x : word_frequency) {
            num_appearance = word_frequency.get(x);
            token = x;

            for (int y = 0; y < bow.length; y++) {
                if (bow[y].equals(token)) {
                    index = y;
                    break;
                }
            }
            frequency_table[index] = num_appearance;
        }

        // print out to standard output.
        for (int check = 0; check < frequency_table.length; check++) {
            StdOut.println(frequency_table[check]);
        }
    }
}

