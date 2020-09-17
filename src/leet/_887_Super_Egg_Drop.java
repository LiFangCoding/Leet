package leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given K eggs, and you have access to a building with N floors from 1 to N. 
 * <p>
 * Each egg is identical in function, and if an egg breaks, you cannot drop it again.
 * <p>
 * You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
 * <p>
 * Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N). 
 * <p>
 * Your goal is to know with certainty what the value of F is.
 * <p>
 * What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: K = 1, N = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 * Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 * If it didn't break, then we know with certainty F = 2.
 * Hence, we needed 2 moves in the worst case to know what F is with certainty.
 * Example 2:
 * <p>
 * Input: K = 2, N = 6
 * Output: 3
 * Example 3:
 * <p>
 * Input: K = 3, N = 14
 * Output: 4
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= K <= 100
 * 1 <= N <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _887_Super_Egg_Drop {
    //TODO
    class Sol_DP_binary {
        public int superEggDrop(int K, int N) {
            // dp[i][j]：一共有 i 层楼梯的情况下，使用 j 个鸡蛋的最少仍的次数
            int[][] dp = new int[N + 1][K + 1];

            // 初始化
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], i);
            }
            for (int j = 0; j <= K; j++) {
                dp[0][j] = 0;
            }

            dp[1][0] = 0;
            for (int j = 1; j <= K; j++) {
                dp[1][j] = 1;
            }
            for (int i = 0; i <= N; i++) {
                dp[i][0] = 0;
                dp[i][1] = i;
            }

            // 开始递推
            for (int i = 2; i <= N; i++) {
                for (int j = 2; j <= K; j++) {
                    // 在区间 [1, i] 里确定一个最优值
                    int left = 1;
                    int right = i;
                    while (left < right) {
                        // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                        int mid = left + (right - left + 1) / 2;

                        int breakCount = dp[mid - 1][j - 1];
                        int notBreakCount = dp[i - mid][j];
                        if (breakCount > notBreakCount) {
                            // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                            // 严格大于的时候一定不是解，此时 mid 一定不是解
                            // 下一轮搜索区间是 [left, mid - 1]
                            right = mid - 1;
                        } else {
                            // 这个区间一定是上一个区间的反面，即 [mid, right]
                            // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                            left = mid;
                        }
                    }
                    // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                    dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
                }
            }
            return dp[N][K];
        }

        // 作者：liweiwei1419
        // 链接：https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/
        // 来源：力扣（LeetCode）
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    /**
     * Time limit exceed. 4, 5000
     * T = k * N ^ 2
     * S= k * N
     * <p>
     * 这个算法的时间复杂度是多少呢？动态规划算法的时间复杂度就是子问题个数 × 函数本身的复杂度。
     * 函数本身的复杂度就是忽略递归部分的复杂度，这里 dp 函数中有一个 for 循环，所以函数本身的复杂度是 O(N)。
     * 子问题个数也就是不同状态组合的总数，显然是两个状态的乘积，也就是 O(KN)。
     * 所以算法的总时间复杂度是 O(K*N^2), 空间复杂度 O(KN)。
     */
    class Sol_DP_brute {
        Map<String, Integer> map = new HashMap<>();

        public int superEggDrop(int K, int N) {
            if (K == 1) {
                return N;
            }

            if (N == 0) {
                return 0;
            }

            String key = K + "," + N;

            if (map.containsKey(key)) {
                return map.get(key);
            }

            int ans = Integer.MAX_VALUE;

            for (int i = 1; i <= N; i++) {
                ans = Math.min(ans, Math.max(superEggDrop(K, N - i), superEggDrop(K - 1, i - 1)) + 1);
            }

            map.put(key, ans);
            return ans;
        }
    }
}
