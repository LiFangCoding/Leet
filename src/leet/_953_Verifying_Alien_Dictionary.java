package leet;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */

public class _953_Verifying_Alien_Dictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        char[] A = order.toCharArray();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        for (int i = 1; i < words.length; i++) {
            // call function. method lessOrEqual in class Solution cannot be applied to given types. Need a map
            if (!lessOrEqual(words[i - 1], words[i], map)) {
                return false;
            }
        }

        return true;
    }

    //  ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    // String comparing order. Just by char. Only one different is ok.
    private boolean lessOrEqual(String s1, String s2, Map<Character, Integer> map) {
        char[] A1 = s1.toCharArray(), A2 = s2.toCharArray();
        int len = Math.max(A1.length, A2.length);

        for (int i = 0; i < len; i++) {
            int idx1 = i < A1.length ? map.get(A1[i]) : -1;
            int idx2 = i < A2.length ? map.get(A2[i]) : -1;

            if (idx1 > idx2) {
                return false;
            } else if (idx1 < idx2) {
                return true;
            }
        }

        return true;
    }
}
