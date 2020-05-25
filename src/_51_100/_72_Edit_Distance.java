package _51_100;

public class _72_Edit_Distance {

  /**
   * 7ms
   * T = O(mn)，其中 mm 为 word1 的长度，nn 为 word2 的长度。
   * S = O(mn)，我们需要大小为 O(mn)O(mn) 的 DD 数组来记录状态值。
   * For two strings, think dp table i and j to solve
   */
  class Sol_DP_loop {
    public int minDistance(String s1, String s2) {
      /**
       * find the minimum number of operations required to convert word1 to word2.
       *
       * the first mth character of s1
       * the first nth character of s2
       * f[m][n] = f[m - 1][n] + 1; deletion
       *           f[m][n - 1] + 1; insertion
       *           f[m - 1][n - 1] + { s1.charAt(m) == s2.charAt(n) ? 0 : 1}
       *
       * res is f[len1][len2]
       */
      int len1 = s1.length();
      int len2 = s2.length();

      /**
       * f is 0,1,... len1
       *      0,1,.. len2
       */
      int[][] f = new int[len1 + 1][len2 + 1];

      for (int i = 0; i <= len1; i++) {
        f[i][0] = i;
      }

      for (int i = 0; i <= len2; i++) {
        f[0][i] = i;
      }

      for (int i = 1; i <= len1; i++) {
        for (int j = 1; j <= len2; j++) {
          f[i][j] = f[i - 1][j] + 1;
          f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
          f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1));
        }
      }

      return f[len1][len2];
    }
  }

  /**
   * 4ms
   * T = O(mn)，其中 mm 为 word1 的长度，nn 为 word2 的长度。
   * S = O(mn)，我们需要大小为 O(mn)O(mn) 的 DD 数组来记录状态值。
   */
  class Sol_DP_recursion {
    Integer[][] memo;

    public int minDistance(String s1, String s2) {
      memo = new Integer[s1.length()][s2.length()];

      // from 0,...ith char.
      return min(s1, s1.length() - 1, s2, s2.length() - 1);
    }

    private int min(String s1, int i1, String s2, int i2) {
      if (i1 == -1) {
        return i2 + 1;
      }

      if (i2 == -1) {
        return i1 + 1;
      }

      if (memo[i1][i2] != null) {
        return memo[i1][i2];
      }

      if (s1.charAt(i1) == s2.charAt(i2)) {
        memo[i1][i2] = min(s1, i1 - 1, s2, i2 - 1);
      } else {
        int insert = min(s1, i1, s2, i2 - 1) + 1;
        int delete = min(s1, i1 - 1, s2, i2) + 1;
        int replace = min(s1, i1 - 1, s2, i2 - 1) + 1;

        memo[i1][i2] = Math.min(insert, Math.min(delete, replace));
      }

      return memo[i1][i2];
    }
  }
}
