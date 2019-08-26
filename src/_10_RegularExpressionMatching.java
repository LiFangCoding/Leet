/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean T[][] = new boolean[text.length+1][pattern.length+1];
        T[0][0] = true;
        for(int i = 1; i < T[0].length; i++){
            if(pattern[i-1] == '*'){
                T[0][i] = T[0][i-2];
            }
        }

        for(int i = 1; i < T.length; i++){
            for(int j = 1; j < T[0].length; j++){
                if(pattern[j-1] == '.' || pattern[j-1] == text[i-1]){
                    T[i][j] = T[i-1][j-1];
                }else if (pattern[j-1] == '*'){
                    T[i][j] = T[i][j-2];
                    if(pattern[j-2] == '.' || pattern[j-2] == text[i-1]){
                        T[i][j] = T[i][j] | T[i-1][j];
                    }
                }else{
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }

    /**
     *  vector<vector<int>>f;
     *     int n, m;
     *     bool isMatch(string s, string p) {
     *         n = s.size();
     *         m = p.size();
     *         f = vector<vector<int>>(n + 1, vector<int>(m + 1, -1));
     *         return dp(0, 0, s, p);
     *     }
     *
     *     bool dp(int x, int y, string &s, string &p)
     *     {
     *         if (f[x][y] != -1) return f[x][y];
     *         if (y == m)
     *             return f[x][y] = x == n;
     *         bool first_match = x < n && (s[x] == p[y] || p[y] == '.');
     *         bool ans;
     *         if (y + 1 < m && p[y + 1] == '*')
     *         {
     *             ans = dp(x, y + 2, s, p) || first_match && dp(x + 1, y, s, p);
     *         }
     *         else
     *             ans = first_match && dp(x + 1, y + 1, s, p);
     *         return f[x][y] = ans;
     *
     * 作者：yxc
     * 链接：https://www.acwing.com/solution/LeetCode/content/102/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
