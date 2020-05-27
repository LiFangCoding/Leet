package _101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 */
public class _131_Palindrome_Partitioning {
    /**
     * 2ms
     * 首先我们预处理好哪些子串是回文串，这个可以用动态规划在O(n2)O(n2)的时间内处理好，dp[i][j]代表s[i:j]是回文串。
     * 然后进行递归搜索，u代表当前处理到哪个位置，我们从当前位置开始，枚举所有可能的回文子串，进行递归搜索直至处理完整个字符串。
     * 最坏的情况是整个字符串都是同一个字符，这需要O(2n)O(2n)时间复杂度
     */
    class Sol_backtrack_dp {
        List<List<String>> ans;
        List<String> path;


        public List<List<String>> partition(String s) {
            ans = new ArrayList<>();
            path = new ArrayList<>();

            if (s == null) {
                return ans;
            }

            int len = s.length();
            // 预处理
            // 状态：dp[i][j] 表示 s[i][j] 是否是回文
            boolean[][] dp = new boolean[len][len];
            // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
            for (int right = 0; right < len; right++) {
                // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
                for (int left = 0; left <= right; left++) {
                    if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                        dp[left][right] = true;
                    }
                }
            }
//
//            作者：liweiwei1419
//            链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
//            来源：力扣（LeetCode）
//            著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

            /**
             * Use the chars array will improve from 4ms to 1ms and beat 100%
             */
            search(s, 0, dp);
            return ans;
        }

        private void search(String s, int start, boolean[][] dp) {
            /**
             * base case. return
             */
            if (start == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }

            /**
             * start ~ i
             */
            for (int i = start; i < s.length(); i++) {
                if (dp[start][i]) {
                    path.add(s.substring(start, i + 1));
                    search(s, i + 1, dp);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    /**
     * 2ms
     * T = 2^n * n
     * S = 2^n * n
     * https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
     * 首先考虑最多有多少个合法方案，我们可以考虑在相邻字符之间放板子，每种放板子的方法都对应一种划分方案，而每个字符间隔有放和不放两种选择，所以总共有 2^(n−1()个方案。
     * 另外对于每个方案，需要 O(n)的时间记录方案。所以总时间复杂度是 O(2^n * n)。
     */
    class Sol_Backtrack_Brute {
        List<List<String>> ans;
        List<String> path;


        public List<List<String>> partition(String s) {
            ans = new ArrayList<>();
            path = new ArrayList<>();

            if (s == null) {
                return ans;
            }

            /**
             * Use the chars array will improve from 4ms to 1ms and beat 100%
             */
            search(s, 0);
            return ans;
        }

        private void search(String s, int start) {
            /**
             * base case. return
             */
            if (start == s.length()) {
                ans.add(new ArrayList<>(path));
                return;
            }

            /**
             * start ~ i
             */
            for (int i = start; i < s.length(); i++) {
                if (isValid(s, start, i)) {
                    path.add(s.substring(start, i + 1));
                    search(s, i + 1);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isValid(String s, int l, int r) {
            for (int i = l, j = r; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }

            return true;
        }
    }

}
