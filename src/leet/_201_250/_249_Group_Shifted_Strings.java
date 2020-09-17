package leet._201_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * <p>
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * <p>
 * Example:
 * <p>
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */
public class _249_Group_Shifted_Strings {
    public static void main(String[] args) {
        _249_Group_Shifted_Strings test = new _249_Group_Shifted_Strings();
        String[] strings = new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
        test.groupStrings(strings);
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        if (strings == null || strings.length == 0) {
            return res;
        }

        for (String s : strings) {
            String t = transform(s);
            if (map.containsKey(t)) {
                map.get(t).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(t, list);
                res.add(list);
            }
        }

        return res;
    }

    /**
     * Make each string the first char to 'a'. Then see if it exists
     */
    private String transform(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        if (len == 0) {
            return "";
        }

        /**
         * first char this distance to move
         */
        int offset = s.charAt(0);

        for (int i = 0; i < len; i++) {
            char c = chars[i];
            /*
             * !!! transform char.
             * Cannot use % 26 directly, since it can begins from 97 - 122
             *
             * d c e
             * a z b
             * d - a = 3
             * c - 3 = z
             */
            char trans = (char) ('a' + (chars[i] - offset + 26) % 26);
            chars[i] = trans;
        }

        return new String(chars);
    }
}
