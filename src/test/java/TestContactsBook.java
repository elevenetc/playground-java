import org.junit.Test;
import su.levenetc.playground.java.datastructures.ContactsBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 09/03/2017.
 */
public class TestContactsBook {

    @Test
    public void testSomeValues() {
        ContactsBook cb = new ContactsBook();

        cb.add("ab");
        assertEquals(1, cb.find("a"));
        cb.add("abc");
        assertEquals(2, cb.find("ab"));
        cb.add("a");
        assertEquals(0, cb.find("xb"));
    }

    @Test
    public void test10000() throws IOException {
        readString(loadChecks());
    }

    private List<Integer> loadChecks() throws IOException {
        List<Integer> result = new ArrayList<>();
        File file = new File("files/output04.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                result.add(Integer.valueOf(line));
            }
        }

        return result;
    }

    private void readString(List<Integer> checks) throws IOException {

        File file = new File("files/input04.txt");

        ContactsBook cb = new ContactsBook();

        int lines = -1;
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (lines == -1) {
                    lines = Integer.valueOf(line);
                } else {
                    final String[] split = line.split(" ");
                    final String command = split[0];
                    final String string = split[1];

                    if ("add".equals(command)) {
                        cb.add(string);
                    } else if ("find".equals(command)) {
                        final int i = cb.find(string);
                        final int expected = checks.get(index);
                        if (expected != i) {
                            throw new RuntimeException("error at" + index + " expected: " + expected + " found: " + i + " was searching for: " + string);
                        }

                        index++;
                    }
                }
            }
        }
    }


}