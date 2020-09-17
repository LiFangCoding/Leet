package leet._451_500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class _451_SortCharsByFrequency {
    public String frequencySort(String s) {
        if (s == null) {
            return "";
        }

        char[] sA = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : sA) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keylist = new ArrayList<>(map.keySet());
        Collections.sort(keylist, (k1, k2) -> Integer.compare(map.get(k2), map.get(k1)));

        StringBuilder sb = new StringBuilder();
        for (char c : keylist) {
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
