package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
            Map<Group, Group> groups = new HashMap<>();
            Group initGroup = new Group(strs[0]);
            groups.put(initGroup, initGroup);

            for (int i = 1; i < strs.length; i++) {
                String s = strs[i];

                Group tmpGroup = new Group(s);

                if (groups.containsKey(tmpGroup)) {
                    groups.get(tmpGroup).words.add(s);
                } else {
                    groups.put(tmpGroup, tmpGroup);
                }
            }

            for (Group g : groups.keySet()) {
                result.add(g.words);
            }
        }

        return result;
    }

    static class Group {

        Map<Character, Integer> chars = new HashMap<>();
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
