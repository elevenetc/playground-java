package su.levenetc.playground.java.algs;

class ThreeTypesOfEdits {

    static boolean isValidEdit(String valueA, String valueB) {
        int diff = Math.abs(valueA.length() - valueB.length());
        if (diff > 1) return false;
        if (valueA.length() == 0 || valueB.length() == 0) return true;

        if (diff == 0) {
            return isOnceReplaced(valueA, valueB);
        } else {
            return isOnceInsertedOrDeleted(valueA, valueB);
        }
    }

    private static boolean isOnceReplaced(String valueA, String valueB) {
        boolean foundReplacement = false;
        for (int i = 0; i < valueA.length(); i++) {
            char chA = valueA.charAt(i);
            char chB = valueB.charAt(i);

            if (foundReplacement) {
                if (chA != chB) {
                    return false;
                }
            } else {
                if (chA != chB) {
                    foundReplacement = true;
                }
            }
        }
        return true;
    }

    private static boolean isOnceInsertedOrDeleted(String valueA, String valueB) {
        String max, min;

        if (valueA.length() > valueB.length()) {
            max = valueA;
            min = valueB;
        } else {
            max = valueB;
            min = valueA;
        }

        boolean foundChanged = false;

        for (int i = 0; i < max.length() - 1; i++) {

            char maxCh = max.charAt(i);
            char minCh = min.charAt(i);

            if (maxCh == minCh) {
                continue;
            } else {

                if (foundChanged) return false;

                foundChanged = true;
            }

        }

        if (!foundChanged) {
            return true;
        } else {
            return max.charAt(max.length() - 1) == min.charAt(min.length() - 1);
        }
    }
}
