package _1_50;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class _10_RegularExpressionMatching {
  //TODO
  /**
   * https://leetcode-cn.com/problems/regular-expression-matching/solution/ji-yu-guan-fang-ti-jie-gen-xiang-xi-de-jiang-jie-b/
   *      * 题解：双字符串的匹配问题，可以用动态规划来做。
   *         * <p>
   *        * 状态表示：dp[i][j]代表s的前i个字符和p的前j个字符是否匹配。
   *         * <p>
   *        * 状态初始化：dp[0][0] = true，对于1 <= i <= m如果p[i - 1] = '*' && dp[0][i - 2]那么dp[0][i] = true，这对应着p以a*b*c*…开头的字符串，因为*可以代表0个字符，所以可以往后匹配。
   *         * <p>
   *        * 状态转移：
   *         * <p>
   *        * s[i - 1] == p[j - 1] || p[j - 1] == '.'，这时候是精准匹配，所以取决于s的前i - 1个字符和p的前j - 1个字符是否匹配。dp[i][j] = dp[i - 1][j - 1];
   *        * <p>
   *        * p[j - 1] = '*'，这个时候就比较麻烦了，我们根据*前的字符和s当前字符能否匹配分为两种情况：
   *         * <p>
   *        * 如果不能匹配，那么*只能代表0个字符，这时候取决于s的前i个字符和p的前j - 2个字符是否匹配。dp[i][j] = dp[i][j - 2];
   *        * <p>
   *        * 如果能匹配有3种可能的情况，需要对这三种情况取或：
   *         * <p>
   *        * *代表0个字符，这时候这时候取决于s的前i个字符和p的前j - 2个字符是否匹配。dp[i][j] = dp[i][j - 2];
   *        * <p>
   *        * *代表1个字符，这时候这时候取决于s的前i个字符和p的前j - 1个字符是否匹配。dp[i][j] = dp[i][j - 1];(这里因为s的第i个字符已经和p的第j - 1个字符匹配了，所以也可以是dp[i][j] = dp[i - 1][j - 2])
   *         * <p>
   *        * *代表多个字符，这时候取决于取决于s的前i - 1个字符和p的前j个字符是否匹配。dp[i][j] = dp[i - 1][j];这是因为如果*代表多个字符的时候，去掉s的第i个字符对匹配结果不影响。
   *         * <p>
   *        * 作者：T-SHLoRk
   *        * 链接：https://www.acwing.com/solution/LeetCode/content/3637/
   *         * 来源：AcWing
   *        * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */

  class Sol_recursion_only {
    /**
     * Recursion only
     */
    public boolean isMatch(String text, String pattern) {
      if (pattern.isEmpty()) {
        return text.isEmpty();
      }
      boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

      if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
        return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
      } else {
        return first_match && isMatch(text.substring(1), pattern.substring(1));
      }
    }
  }

  class Sol_recursion_Memo {
    /**
     * 用 TT 和 PP 分别表示匹配串和模式串的长度。对于i=0, ... , Ti=0,...,T 和 j=0, ... , Pj=0,...,P 每一个 dp(i, j)只会被计算一次，所以后面每次调用都是 O(1)O(1) 的时间。因此，总时间复杂度为 O(TP)O(TP) 。
     * <p>
     * 空间复杂度：我们用到的空间仅有 O(TP)个 boolean 类型的缓存变量。所以，空间复杂度为 O(TP)。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    Boolean[][] memo;

    public boolean isMatch(String text, String pattern) {
      memo = new Boolean[text.length() + 1][pattern.length() + 1];
      return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
      if (memo[i][j] != null) {
        return memo[i][j];
      }

      boolean ans;
      if (j == pattern.length()) {
        ans = i == text.length();
      }
      // cannot have else if cause "aa" "a*". actual: false. exp : true
//      else if (i == text.length()) {
//        ans = j == pattern.length();
//      }
      else {
        boolean first_match = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');

        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
          ans = dp(i, j + 2, text, pattern) || (first_match && dp(i + 1, j, text, pattern));
        } else {
          ans = first_match && dp(i + 1, j + 1, text, pattern);
        }
      }

      memo[i][j] = ans;
      return ans;
    }
  }

  class Sol_bottom_Top {
    /**
     * 用 TT 和 PP 分别表示匹配串和模式串的长度。对于i=0, ... , Ti=0,...,T 和 j=0, ... , Pj=0,...,P 每一个 dp(i, j)只会被计算一次，所以后面每次调用都是 O(1)O(1) 的时间。因此，总时间复杂度为 O(TP)O(TP) 。
     * <p>
     * 空间复杂度：我们用到的空间仅有 O(TP)O(TP) 个 boolean 类型的缓存变量。所以，空间复杂度为 O(TP)O(TP) 。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * (动态规划) O(n∗m)
     */
    public boolean isMatch(String text, String pattern) {
      boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
      dp[text.length()][pattern.length()] = true;

      for (int i = text.length(); i >= 0; i--) {
        for (int j = pattern.length() - 1; j >= 0; j--) {
          boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
          if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
          } else {
            dp[i][j] = first_match && dp[i + 1][j + 1];
          }
        }
      }
      return dp[0][0];
    }
  }
}
