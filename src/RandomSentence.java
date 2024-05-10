import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RandomSentence {

    private final static String word_list = "words.txt";

    public static ArrayList<ArrayList<Character>> create_sentence(){

        int sentence_length = 7 + (int) (Math.random() * (15 - 7 + 1));
        ArrayList<ArrayList<Character>> sentence = new ArrayList<>();

        for(int i = 0; i < sentence_length; i++){

            String new_word = create_word();
            ArrayList<Character> word = new ArrayList<>();

            for (int j = 0; j < new_word.length(); j++){
                word.add(new_word.charAt(j));
            }

            sentence.add(word);

        }

        return sentence;

    }

    public static String create_word() {

        String word = "";

        while (word.length() <= 1) {

            try {
                word = Files.readAllLines(Paths.get(word_list))
                        .get((int) (Math.random() * (999)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        return word;

    }

}
