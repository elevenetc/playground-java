package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eugene.levenetc on 26/04/2017.
 */
public class Crossword {

    public static class Graph {

        CharMatrix charMatrix = new CharMatrix();
        Queue<PlaceHolder> phs;
        Queue<PlaceHolder> horiz;
        Queue<PlaceHolder> vert;
        String[] rows;

        public void cross(Letter letterA, Letter letterB) {
            letterA.cross = letterB;
            letterB.cross = letterA;
        }

        public void set(String... rows) {

            this.rows = rows;
            charMatrix.set(rows);

            String[] columns = new String[rows.length];
            horiz = new LinkedList<>();
            vert = new LinkedList<>();

            for (int y = 0; y < rows.length; y++) {
                String row = rows[y];

                parsePlaceholder(row, horiz, y, true);

                //build columns
                for (int colInd = 0; colInd < row.length(); colInd++) {
                    final char ch = row.charAt(colInd);
                    if (columns[colInd] == null) {
                        columns[colInd] = String.valueOf(ch);
                    } else {
                        columns[colInd] += String.valueOf(ch);
                    }
                }
            }

            for (int i = 0; i < columns.length; i++) {
                parsePlaceholder(columns[i], vert, i, false);
            }

            for (PlaceHolder h : horiz) {
                for (PlaceHolder v : vert) {
                    final int[] intersection = h.intersection(v);
                    if (intersection != null) {
                        Letter letterA = v.getLetter(intersection[0], intersection[1]);
                        Letter letterB = h.getLetter(intersection[0], intersection[1]);
                        if(letterA == null || letterB == null) continue;
                        cross(letterA, letterB);
                    }
                }
            }

            LinkedList<PlaceHolder> h = new LinkedList<>(horiz);
            LinkedList<PlaceHolder> v = new LinkedList<>(vert);
            h.addAll(v);
            set(h);
        }

        public String[] toStringRows() {
            for (PlaceHolder ph : horiz) {
                charMatrix.fill(ph.toString(), ph.x, ph.y, true);
            }

            for (PlaceHolder ph : vert) {
                charMatrix.fill(ph.toString(), ph.x, ph.y, false);
            }
            return charMatrix.toRows();
        }

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

        private static void parsePlaceholder(String line, Queue<PlaceHolder> placeholders, int y, boolean isHorisontal) {
            if (line.contains("--")) {

                Pattern pattern = Pattern.compile("[\\-]{2,}");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String rawPh = matcher.group();
                    int x = matcher.start();

                    PlaceHolder ph;
                    if (isHorisontal) {
                        ph = new PlaceHolder(x, y, rawPh.length());
                    } else {
                        ph = new PlaceHolder(y, x, rawPh.length());
                    }

                    ph.isHorizontal = isHorisontal;
                    ph.buildCoordinates();
                    placeholders.add(ph);
                }

            }
        }
    }

    public static class PlaceHolder {

        List<Letter> letters;
        int length;
        int x;
        int y;
        boolean isHorizontal;

        public PlaceHolder(int x, int y, int length, boolean isHorizontal) {
            this(x, y, length);
            this.isHorizontal = isHorizontal;
        }

        public PlaceHolder(int x, int y, int length) {
            this(length);
            this.x = x;
            this.y = y;
        }

        public PlaceHolder(int length) {
            this.length = length;
            letters = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                letters.add(new Letter());
            }
        }

        public void buildCoordinates() {
            for (int i = 0; i < letters.size(); i++) {
                final Letter letter = letters.get(i);
                if (isHorizontal) {
                    letter.x = x + i;
                    letter.y = y;
                } else {
                    letter.x = x;
                    letter.y = y + i;
                }
            }
        }

        public Letter getLetter(int x, int y) {
            if (isHorizontal) {
                if (this.y != y) return null;
                return Utils.get(letters, x - this.x);
            } else {
                if (this.x != x) return null;
                return Utils.get(letters, y - this.y);
            }
        }

        public Letter getLetter(int index) {
            return letters.get(index);
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

                if (!letter.isEmpty() && ch != letter.ch || (letter.isCross() && !letter.isEmpty() && ch != letter.cross.ch)) {
                    return false;
                }
            }

            for (int i = 0; i < letters.size(); i++) {
                final Letter letter = letters.get(i);
                final char ch = word.charAt(i);

                if (letter.isEmpty()) {
                    letter.ch = ch;

                    if (letter.isCross()) {
                        letter.cross.ch = ch;
                    }
                }
            }

            return true;
        }

        public int[] intersection(PlaceHolder ph) {
            if (ph.isHorizontal != isHorizontal) {

                PlaceHolder horiz = isHorizontal ? this : ph;
                PlaceHolder vert = isHorizontal ? ph : this;
                boolean isXOk = horiz.x <= vert.x && horiz.x + length >= vert.x;
                boolean isYOk = vert.y <= horiz.y && vert.y + length >= horiz.y;

                if (isXOk && isYOk) {
                    int x = vert.x;
                    int y = horiz.y;
                    return new int[]{x, y};
                } else {
                    return null;
                }


            } else {
                return null;
            }
        }

        public void unset() {
            for (Letter letter : letters) {
                letter.ch = (char) -1;

                if (letter.isCross()) {
                    letter.cross.ch = (char) -1;
                }
            }
        }

        public String getFilled(String row) {
            return row.replaceFirst("-+", toString());
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

        public int x, y;
        char ch = (char) -1;
        Letter cross;

        public char getChar() {
            return ch;
        }

        boolean isCross() {
            return cross != null;
        }

        boolean isEmpty() {
            return ch == (char) -1;
        }

        @Override
        public String toString() {
            return String.valueOf(ch);
        }
    }

}
