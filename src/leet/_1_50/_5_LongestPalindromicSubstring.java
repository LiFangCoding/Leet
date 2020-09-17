package leet._1_50;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class _5_LongestPalindromicSubstring {
    //TODO: more practice

    /**
     * T = n^2
     * S =
     */
    class Sol_Expand {
        // expand around center
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String odd = expand(s, i, i);
                if (res.length() < odd.length()) {
                    res = odd;
                }
                String even = expand(s, i, i + 1);
                if (res.length() < even.length()) {
                    res = even;
                }
            }
            return res;
        }

        // expand center from l and r index
        // "aba"
        private String expand(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                // if change to s.toCharArray A. A[l], A[r]. It will be 5 times slow
                l--;
                r++;
            }

            return s.substring(l + 1, r);
        }
    }
}
