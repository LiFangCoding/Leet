package _1_50;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
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
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _44_Wildcard_Matching {
    /**
     * T = n * m
     * S = n * m
     * (动态规划) O(nm)
     * 设状态 f(i,j) 表示 s 串的前 i 个字符与 p 串的前 j 个字符是否匹配。这里的有效下标从 1 开始。
     * 假设 s 串的长度为 n，p 串的长度为 m。
     * 初始化 f(0,0)=true，其余待定。
     * 转移方程，假设 s 串的第 i 个字符为变量 x，p 串的第 j 个字符为变量 y。
     * (1) f(i, j) = f(i, j) | f(i - 1, j - 1) 当且仅当 x == y 或 y == '?'。
     * (2) f(i, j) = f(i, j) | f(i - 1, j) | f(i, j - 1)当且仅当 y == '*'。
     * 解释：
     * (1) 的含义是 s 串的第 i 个字符与 p 串的第 j 个字符匹配对应，所以 f(i,j) 的值可以由 f(i−1,j−1)的值来转移。
     * (2) 的含义是，特别地，如果 p 串的第 j 个字符为 *，
     * 则可以让 s 串的第 i 个字符同之前的字符串一起（之前的字符串可以为空）与这个 * 对应，
     * 或者是 s 串的第 i 个字符与 p 串的第 j−1个字符对应（* 匹配零个字符）。
     * 最终 f(n,m) 的值表示字符串是否匹配。
     * 时间复杂度
     * 状态数量为 O(nm），转移时间为 O(1)。故总时间复杂度为 O(nm)。
     * 空间复杂度
     * 需要额外 O(nm)的空间存储状态。
     * <p>
     * 作者：wzc1995
     * 链接：https://www.acwing.com/solution/content/127/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char y = p.charAt(j - 1);
                if (i > 0) {
                    char x = s.charAt(i - 1);
                    if (x == y || y == '?') {
                        f[i][j] = f[i][j] || f[i - 1][j - 1];
                    }
                }

                if (y == '*') {
                    f[i][j] = f[i][j] || f[i][j - 1];
                    if (i > 0) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
            }
        }

        return f[n][m];
    }
}
