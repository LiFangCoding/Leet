package _601_650;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *  
 * <p>
 * Example 2:
 * <p>
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *  
 * <p>
 * Note:
 * <p>
 * The input string length won't exceed 1000.
 */
public class _647_Palindromic_Substrings {
    /**
     * 3 ms
     * T = n ^ 2
     * S = 1
     */
    class Sol_Expand {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                ans += expand(s, i, i);
                ans += expand(s, i, i + 1);
            }

            return ans;
        }

        private int expand(String s, int l, int r) {
            int ans = 0;
            int len = s.length();

            while (l >= 0 && r < len) {
                if (s.charAt(l) == s.charAt(r)) {
                    ans++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }

            return ans;
        }
    }
}
