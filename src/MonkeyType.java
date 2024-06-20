import java.util.ArrayList;

public class MonkeyType {

    private final ArrayList<ArrayList<Character>> words = new ArrayList<>();
    private ArrayList<Character> word = new ArrayList<>();
    private ArrayList<ArrayList<Character>> sentence;

    public static void main(String[/* (╯°□°)╯︵ ┻━┻ */] args) {
			new MonkeyType();
    }

    public MonkeyType() {

        InputHandler inputHandler = new InputHandler(this);
        inputHandler.build_input_field();

        create_new_sentence();
        print_line();

    }

    public void create_new_sentence() {

        this.sentence = SentenceCreator.create_sentence();
        word.clear();
        words.clear();
        System.out.print(AnsiCodes.ANSI_TERMINAL_RESET);

    }

    public void remove_last_char() {

        if (!word.isEmpty()) {
            word.removeLast();
        }

    }

    public void handle_char_input(char character) {

        if(character == ' ' && !word.isEmpty()) {
            words.add(word);
            word = new ArrayList<>();
        } else if (character != ' ' && words.size() < sentence.size()) {
            word.add(character);
        }

    }

    public void print_line() {

        String line = build_written_words() + build_current_word() + build_unwritten_words();
        System.out.print(line);

    }

    public String build_written_words () {

        StringBuilder output_line = new StringBuilder();
        output_line.append(AnsiCodes.ANSI_CURSOR_RESET);

        int word_count = words.size();

        for (int i = 0; i < word_count; i++){

            int true_word_size = sentence.get(i).size();
            int current_word_size = words.get(i).size();

            for (int j = 0; j < true_word_size; j++){

                if (j > current_word_size - 1) {
                    output_line.append(AnsiCodes.create_ansi_character(AnsiCodes.ANSI_RED_BACKGROUND, ' '));
                } else {

                    char character = words.get(i).get(j);

                    if (character == sentence.get(i).get(j)) {
                        output_line.append(AnsiCodes.create_ansi_character(AnsiCodes.ANSI_WHITE, character));
                    } else {
                        output_line.append(AnsiCodes.create_ansi_character(AnsiCodes.ANSI_RED, character));
                    }

                }

            }

            for (int j = true_word_size; j < current_word_size; j++) {

                char character = words.get(i).get(j);
                output_line.append(AnsiCodes.create_ansi_character(AnsiCodes.ANSI_RED, character));

            }

            output_line.append(" ");

        }

        return output_line.toString();

    }

    public String build_current_word() {

        StringBuilder output_line = new StringBuilder();

        int word_count = words.size();
        int char_count = word.size();

        for (int j = 0; j < char_count; j++){

            char character = word.get(j);

            if (j > sentence.get(word_count).size() - 1 || character != sentence.get(word_count).get(j)) {
                output_line.append(AnsiCodes.create_ansi_character(AnsiCodes.ANSI_RED, character));
            } else {
                output_line.append(AnsiCodes.create_ansi_character(AnsiCodes.ANSI_WHITE, character));
            }

        }

        return output_line.toString();

    }

    public String build_unwritten_words() {

        StringBuilder output_line = new StringBuilder();

        int sentence_size = sentence.size();
        int word_count = words.size();
        int char_count = word.size();

        for (int a = word_count; a < sentence_size; a++){

            int current_word_size = sentence.get(a).size();

            for (int b = char_count; b < current_word_size && a == word_count; b++){

                char character = sentence.get(a).get(b);

                if (b == char_count) {
                    output_line.append(AnsiCodes.create_ansi_character(AnsiCodes.ANSI_WHITE_BACKGROUND, AnsiCodes.ANSI_BLACK, character));
                } else {
                    output_line.append(character);
                }

            }

            for (int b = 0; b < current_word_size && a != word_count; b++){

                char character = sentence.get(a).get(b);
                output_line.append(character);

            }

            output_line.append(" ");

        }

        return output_line.toString();

    }

}
