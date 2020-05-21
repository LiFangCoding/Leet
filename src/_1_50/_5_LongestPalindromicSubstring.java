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

      int len = s.length();
      String ans = "";

      for (int i = 0; i < len; i++) {
        String odd = expandCenter(s, i, i);
        if (ans.length() < odd.length()) {
          ans = odd;
        }

        String even = expandCenter(s, i, i + 1);

        if (ans.length() < even.length()) {
          ans = even;
        }
      }

      return ans;
    }

    // expand center from l and r index
    // "aba"
    private String expandCenter(String s, int l, int r) {
      while (l >= 0 && r < s.length()) {
        // if change to s.toCharArray A. A[l], A[r]. It will be 5 times slow
        if (s.charAt(l) != s.charAt(r)) {
          break;
        }
        l--;
        r++;
      }

      return s.substring(l + 1, r);
    }
  }
}
