package _551_600;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *  
 * <p>
 * Constraints:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _567_Permutation_In_String {

    /**
     * 28ms
     * T = n
     * S = n
     */
    // here s1 is the shorter one. s2 is the long one. see s2 contains s1
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char[] A = s2.toCharArray();
        int matched = 0;

        int l = 0;
        for (int r = 0; r < len2; r++) {
            if (map.containsKey(A[r])) {
                map.put(A[r], map.get(A[r]) - 1);
                if (map.get(A[r]) >= 0) {
                    matched++;
                }
            }

            if (r - l + 1 == len1) {
                if (matched == len1) {
                    return true;
                }

                char lc = A[l];
                l++;

                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) {
                        matched--;
                    }
                }
            }
        }

        return false;
    }
}
