package _101_150;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class _132_Palindrome_Partitioning2 {
    public static void main(String[] args) {
        _132_Palindrome_Partitioning2 test = new _132_Palindrome_Partitioning2();
        System.out.println(test.minCut("aab"));
    }

    /**
     * First, calculate is substring is palindrome.
     * f[i][j] means s[i..j] is palindrome or not
     * f[i][j] = s[i] == s[j] && f[i + 1][j - 1]
     * <p>
     * <p>
     * second dp.
     * dp[i] := min cuts of s[0~i]
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();

        boolean[][] valid = getPalin(s, len);

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = len;
            if (valid[0][i]) {
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (valid[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[len - 1];
    }

    private boolean[][] getPalin(String s, int n) {
        boolean[][] isPalin = new boolean[n][n];
        char[] chars = s.toCharArray();

        for (int mid = 0; mid < n; mid++) {
            for (int i = mid, j = mid; i >= 0 && j < n; i--, j++) {
                if (chars[i] == chars[j]) {
                    isPalin[i][j] = true;
                } else {
                    break;
                }
            }
        }

        for (int mid = 0; mid < n; mid++) {
            for (int i = mid, j = mid + 1; i >= 0 && j < n; i--, j++) {
                if (chars[i] == chars[j]) {
                    isPalin[i][j] = true;
                } else {
                    break;
                }
            }
        }

        return isPalin;
    }
}
