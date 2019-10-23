package _1_50;

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
    // expand around center
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        String res = "";

        for (int i = 0; i < len; i++) {
            String panlin1 = expandCenter(s, i, i);
            String panlin2 = expandCenter(s, i, i + 1);
            if (panlin1.length() > res.length()) {
                res = panlin1;
            }

            if (panlin2.length() > res.length()) {
                res = panlin2;
            }
        }

        return res;
    }

    // expand center from left and right index
    // "aba"
    private static String expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
