package leet._201_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 * Note:
 * You may assume word1 and word2 are both in the list.
 */
public class _245_Shortest_Word_Distance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> idxs = new ArrayList<>();
                idxs.add(i);
                map.put(words[i], idxs);
            } else {
                map.get(words[i]).add(i);
            }
        }

        if (word1.equals(word2)) {
            List<Integer> idxs = map.get(word1);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < idxs.size() - 1; i++) {
                res = Math.min(res, idxs.get(i + 1) - idxs.get(i));
            }
            return res;
        }

        List<Integer> idx1s = map.get(word1);
        List<Integer> idx2s = map.get(word2);

        int res = Integer.MAX_VALUE;
        for (int l = 0, r = 0; l < idx1s.size() && r < idx2s.size(); ) {
            int idx1 = idx1s.get(l);
            int idx2 = idx2s.get(r);

            if (idx1 < idx2) {
                res = Math.min(res, idx2 - idx1);
                l++;
            } else {
                res = Math.min(res, idx1 - idx2);
                r++;
            }
        }

        return res;
    }
}
