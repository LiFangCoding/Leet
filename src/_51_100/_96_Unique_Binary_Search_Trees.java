package _51_100;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 19
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _96_Unique_Binary_Search_Trees {
    class Sol_dp {
        /**
         * Important:
         * find dp function
         *
         * f[n] = sum (f[k] * f[n - k - 1]) k = 0 --- n-1
         *
         * T = n ^ 2
         * (动态规划) O(n2)
         * 状态表示：f[n] 表示 n个节点的二叉搜索树共有多少种。
         * 状态转移：左子树可以有 0,1,…n−1个节点，对应的右子树有 n−1,n−2,…,0个节点，
         * f[n] 是所有这些情况的加和，所以 f[n]=∑n−1 k=0 f[k]∗f[n−1−k]
         *
         * 时间复杂度分析：状态总共有 n 个，状态转移的复杂度是 O(n)，所以总时间复杂度是 O(n2)
         * https://www.acwing.com/solution/content/178/
         */
        public int numTrees(int n) {
            int[] f = new int[n + 1];

            f[0] = 1;

            for (int i = 1; i <= n; i++) {
                f[i] = 0;

                for (int k = 0; k < i; k++) {
                    f[i] += f[k] * f[i - k - 1];
                }
            }

            return f[n];
        }
    }


    class Soltion_memo {
        Map<String, Integer> map;

        public int numTrees(int n) {
            if (n == 0) {
                return 0;
            }

            map = new HashMap<>();
            return num(1, n);
        }

        // can has duplicate cal
        private int num(int l, int r) {
            String key = " " + l + "," + r;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            if (l > r) {
                return 1;
            }

            int ans = 0;
            for (int i = l; i <= r; i++) {
                int lRes = num(l, i - 1);
                int rRes = num(i + 1, r);

                ans += lRes * rRes;
            }

            map.put(key, ans);
            return ans;
        }
    }
}
