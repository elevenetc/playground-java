package su.levenetc.playground.java.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by eugene.levenetc on 26/04/2017.
 */
public class Crossword {

    public static class Graph {

        Queue<PlaceHolder> phs;

        public void set(PlaceHolder... placeHolders) {
            Queue<PlaceHolder> queue = new LinkedList<>();
            for (PlaceHolder ph : placeHolders) queue.add(ph);
            set(queue);
        }

        public void set(Queue<PlaceHolder> placeHolders) {
            this.phs = placeHolders;
        }

        public void fill(String... words) {
            Queue<String> queue = new LinkedList<>();
            for (String word : words) queue.add(word);
            fill(queue);
        }

        public void fill(Queue<String> words) {
            while (!words.isEmpty()) {
                internalFill(words);
            }
        }

        private boolean internalFill(Queue<String> words) {

            if (words.isEmpty()) return true;

            String word = words.poll();

            for (PlaceHolder ph : phs) {
                if (ph.isEmpty() && ph.isFit(word) && ph.set(word)) {

                    if (internalFill(words)) {
                        return true;
                    }

                    ph.unset();
                }
            }

            words.add(word);
            return false;

        }
    }

    public static class PlaceHolder {

        List<Letter> letters;
        int length;


        public PlaceHolder(int length) {
            this.length = length;
            letters = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                letters.add(new Letter());
            }
        }

        public Letter getLetter(int index) {
            return letters.get(index);
        }

        public void setCross(Letter letter, int index) {
            final Letter crossed = letters.get(index);
            crossed.cross = letter;
            letter.cross = crossed;
        }

        boolean isFit(String word) {
            return length == word.length();
        }

        boolean isEmpty() {
            for (Letter letter : letters) {
                if (letter.isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        public boolean set(String word) {

            for (int i = 0; i < letters.size(); i++) {

                final Letter letter = letters.get(i);
                final char ch = word.charAt(i);

                if (!letter.isEmpty() && ch != letter.ch) {
                    return false;
                }
            }

            for (int i = 0; i < letters.size(); i++) {
                final Letter letter = letters.get(i);
                final char ch = word.charAt(i);

                if (letter.isEmpty()) {
                    letter.ch = ch;
                }
            }

            return true;
        }

        public void unset() {
            for (Letter letter : letters) {
                if (!letter.isCross()) {
                    letter.ch = (char) -1;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Letter letter : letters) {
                sb.append(letter.ch);
            }
            return sb.toString();
        }
    }

    public static class Letter {
        char ch = (char) -1;
        Letter cross;

        boolean isCross() {
            return cross != null;
        }

        boolean isEmpty() {
            return ch == (char) -1;
        }
    }

}
