package su.levenetc.playground.java.algs;

import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new LinkedList<>();

        if (strs.length == 0) {
            return result;
        } else if (strs.length == 1) {
            List<String> group = new LinkedList<>();
            group.add(strs[0]);
            result.add(group);
        } else {
            Set<Group> groups = new HashSet<>();
            groups.add(new Group(strs[0]));

            for (int i = 1; i < strs.length; i++) {
                String s = strs[i];
                boolean foundGroup = false;

                Group tmpGroup = new Group(s);

                if (!groups.contains(tmpGroup)) {
                    groups.add(tmpGroup);
                } else {
                    //groups.
                }

                for (Group g : groups) {
                    if (g.fit(s)) {
                        foundGroup = true;
                        g.words.add(s);
                        break;
                    }
                }

                if (!foundGroup) groups.add(new Group(s));
            }

            for (Group g : groups) {
                result.add(g.words);
            }
        }

        return result;
    }

    static class Group {

        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> checkChars = new HashMap<>();
        List<String> words = new LinkedList<>();

        public Group(String s) {
            for (char ch : s.toCharArray()) {
                if (chars.containsKey(ch)) {
                    chars.put(ch, chars.get(ch) + 1);
                } else {
                    chars.put(ch, 1);
                }
            }
            words.add(s);
        }

        public boolean fit(String s) {
            checkChars.clear();

            for (char ch : s.toCharArray()) {
                if (checkChars.containsKey(ch)) {
                    checkChars.put(ch, checkChars.get(ch) + 1);
                } else {
                    checkChars.put(ch, 1);
                }
            }

            return checkChars.equals(chars);
        }

        @Override
        public int hashCode() {
            return chars.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Group)) return false;
            Group g = (Group) o;

            if (g.chars.size() != chars.size()) return false;
            return g.chars.equals(chars);
        }
    }
}
