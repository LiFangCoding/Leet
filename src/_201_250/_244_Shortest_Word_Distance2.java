package _201_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class _244_Shortest_Word_Distance2 {
    /**
     * ["practice", "makes", "perfect", "coding", "makes"]
     * String -> list of integer
     * <p>
     * practice 0
     * makes 1, 4
     * perfect 2
     * coding 3
     */
    Map<String, List<Integer>> map = new HashMap<>();

    public _244_Shortest_Word_Distance2(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> idxs = new ArrayList<>();
                idxs.add(i);
                map.put(words[i], idxs);
            } else {
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
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
