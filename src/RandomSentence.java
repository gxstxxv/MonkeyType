import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RandomSentence {

		private final static int language_index = 0;
		private final static String[][] languages = {
				{"german","202"},
				{"english","999"},
		};

    public static ArrayList<ArrayList<Character>> create_sentence(){

        int sentence_length = 7 + (int) (Math.random() * (10 - 7 + 1));
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
                word = Files.readAllLines(Paths.get("./languages/" + languages[language_index][0] + ".txt"))
                        .get((int) (Math.random() * (Integer.parseInt(languages[language_index][1]))));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        return word;

    }

}
