package _201_250;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
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
public class _243_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int idx1 = -1;
        int idx2 = -1;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            if (s.equals(word1)) {
                idx1 = i;
            } else if (s.equals(word2)) {
                idx2 = i;
            } else {
                continue;
            }

            if (idx1 != -1 && idx2 != -1) {
                res = Math.min(res, Math.abs(idx1 - idx2));
            }
        }

        return res;
    }
}
