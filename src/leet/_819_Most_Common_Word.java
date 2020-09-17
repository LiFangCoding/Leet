package leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class _819_Most_Common_Word {
    public String mostCommonWord(String s, String[] banned) {
        // need to make s as small case first.
        s = s.toLowerCase();
        char[] A = s.toCharArray();
        int len = A.length;

        Set<String> set = new HashSet<>();
        for (String ban : banned) {
            set.add(ban);
        }

        // s -> freq
        Map<String, Integer> map = new HashMap<>();
        int maxCnt = 0;
        String ans = "";

        int l = 0;
        while (true) {
            while (l < len && !valid(A[l])) {
                l++;
            }

            if (l == len) {
                break;
            }

            int r = l;
            while (r < len && valid(A[r])) {
                r++;
            }

            // r is not valid idx or len.
            // s need to be small case. Else ball, BALL.
            String word = s.substring(l, r);
            // System.out.println(word);
            l = r;

            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > maxCnt) {
                    ans = word;
                    maxCnt = map.get(word);
                }
            }
        }

        return ans;
    }

    // a - z
    private boolean valid(char c) {
        return c >= 'a' && c <= 'z';
    }
}
