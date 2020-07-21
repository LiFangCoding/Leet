package _51_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */


public class _97_Interleaving_String {
    //TODO
    class Sol_dp {
        /**
         * 8ms
         * T = n ^ 2
         * sequence question.
         * f[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符是否可以交错组成 s3 的前 i+j 个字符
         * f[i][j]= {f[i-1][j] (if s3[i + j] = s1[i]) || f[i][j - 1] (if s3[i + j] = s2[j])}
         * 时间复杂度分析：状态总共有 n2 个，状态转移复杂度是 O(1)。所以总时间复杂度是 O(n2)。
         * https://www.acwing.com/solution/content/179/
         */
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1 == null || s2 == null || s3 == null) {
                return false;
            }

            int len1 = s1.length();
            int len2 = s2.length();
            int len3 = s3.length();

            if (len1 + len2 != len3) {
                return false;
            }

            boolean[][] f = new boolean[len1 + 1][len2 + 1];

            f[0][0] = true;
            for (int i = 1; i <= len1; i++) {
                /**
                 * charAt(i - 1) is the ith num
                 */
                f[i][0] = f[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            }

            for (int i = 1; i <= len2; i++) {
                f[0][i] = f[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
            }

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    f[i][j] = false;
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }

                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        f[i][j] = f[i][j] || f[i][j - 1];
                    }
                }
            }

            return f[len1][len2];
        }
    }

  /**
   * 2ms
   * T = n ^ 2
   */
  class Sol_recur_memo {
    Map<String, Boolean> map = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
      if (s1 == null || s2 == null || s3 == null) {
        return false;
      }

      int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
      if (len1 + len2 != len3) {
        return false;
      }

      return isInterleave(s1, 0, len1 - 1, s2, 0, len2 - 1, s3, 0, len3 - 1);
    }

    private boolean isInterleave(String s1, int l1, int r1, String s2, int l2, int r2, String s3, int l3, int r3) {
      // System.out.printf("%d, %d, %d,  %d, %d, %d%n", l1, r1, l2, r2, l3, r3);
      int[] vals = new int[] { l1, r1, l2, r2, l3, r3 };
      String key = Arrays.toString(vals);
      boolean ans = false;

      if (map.containsKey(key)) {
        return map.get(key);
      }

      if (l1 > r1) {
        ans = s2.substring(l2, r2 + 1).equals(s3.substring(l3, r3 + 1));
      } else if (l2 > r2) {
        ans = s1.substring(l1, r1 + 1).equals(s3.substring(l3, r3 + 1));
      } else {
        if (s1.charAt(r1) == s3.charAt(r3)) {
          ans = isInterleave(s1, l1, r1 - 1, s2, l2, r2, s3, l3, r3 - 1);
        }

        if (!ans) {
          if (s2.charAt(r2) == s3.charAt(r3)) {
            ans = isInterleave(s1, l1, r1, s2, l2, r2 - 1, s3, l3, r3 - 1);
          }
        }
      }

      // System.out.printf("s1 range is %s, s2 range is %s, s3 range is %s, ans is %b%n", s1.substring(l1, r1 + 1), s2.substring(l2, r2 + 1), s3.substring(l3, r3 + 1), ans);
      map.put(key, ans);
      return ans;
    }
  }

  /**
   * 2220 ms
   * T = exponential
   */
  class Sol_recur {
    Map<String, Boolean> map = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
      if (s1 == null || s2 == null || s3 == null) {
        return false;
      }

      int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
      if (len1 + len2 != len3) {
        return false;
      }

      return isInterleave(s1, 0, len1 - 1, s2, 0, len2 - 1, s3, 0, len3 - 1);
    }

    private boolean isInterleave(String s1, int l1, int r1, String s2, int l2, int r2, String s3, int l3, int r3) {
      // System.out.printf("%d, %d, %d,  %d, %d, %d%n", l1, r1, l2, r2, l3, r3);
      int[] vals = new int[] { l1, r1, l2, r2, l3, r3 };
      String key = Arrays.toString(vals);
      boolean ans = false;

      if (map.containsKey(key)) {
        return map.get(key);
      }

      if (l1 > r1) {
        ans = s2.substring(l2, r2 + 1).equals(s3.substring(l3, r3 + 1));
      } else if (l2 > r2) {
        ans = s1.substring(l1, r1 + 1).equals(s3.substring(l3, r3 + 1));
      } else {
        if (s1.charAt(r1) == s3.charAt(r3)) {
          ans = isInterleave(s1, l1, r1 - 1, s2, l2, r2, s3, l3, r3 - 1);
        }

        if (!ans) {
          if (s2.charAt(r2) == s3.charAt(r3)) {
            ans = isInterleave(s1, l1, r1, s2, l2, r2 - 1, s3, l3, r3 - 1);
          }
        }
      }

      // System.out.printf("s1 range is %s, s2 range is %s, s3 range is %s, ans is %b%n", s1.substring(l1, r1 + 1), s2.substring(l2, r2 + 1), s3.substring(l3, r3 + 1), ans);
      map.put(key, ans);
      return ans;
    }
  }
}
