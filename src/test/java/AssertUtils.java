import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 13/04/2017.
 */
public class AssertUtils {

    public static <T> void assertContains(List<Set<T>> sets, T... checkSet) {
        boolean contains = false;
        for (Set<T> set : sets) {
            contains = true;
            for (T object : checkSet) {
                if (!set.contains(object)) {
                    contains = false;
                    break;
                }
            }
            if(contains){
                break;
            }
        }
        if (!contains) {
            throw new AssertionError("No checkSet " + Arrays.toString(checkSet) + " in sets " + sets.toString());
        }
    }

    public static <T> void assertContains(Set<T> set, T... objects) {
        for (T object : objects) {
            assertTrue(set.contains(object));
        }
    }
}
