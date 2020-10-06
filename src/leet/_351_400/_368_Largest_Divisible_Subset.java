package leet._351_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 * <p>
 * Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _368_Largest_Divisible_Subset {
    class Sol_dp_two_times {
        // 考虑，每个数选不选。 求满足要求的所有序列里面最长的序列。 排好序，有序。 后面的数一定是前面一个数的倍数
        // 任意数是倍数。 a1/a2, a2/a3 ... ak-1/ak. 只用看相邻元素整除。
        // 类似最长子序列
        // F[i]  是 a[i]结尾长度最长子序列 F[i] = max(f[i], f[j] + 1) aj / i
        // n ^ 2
        // dp问题求方案。 f[k]代表必然选a[k], f[k] 有a[t]更新，就选a[t]
        public List<Integer> largestDivisibleSubset(int[] w) {
            List<Integer> res = new ArrayList<>();
            if (w == null || w.length == 0) {
                return res;
            }
            Arrays.sort(w);
            int n = w.length;
            int[] f = new int[n];

            // k means max idx
            int k = 0;
            for (int i = 0; i < n; i++) {
                f[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (w[i] % w[j] == 0) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                if (f[k] < f[i]) k = i;
            }

            // reverse order first.
            res.add(w[k]);
            while (f[k] > 1) {
                for (int i = 0; i < k; i++) {
                    if (w[k] % w[i] == 0 && f[k] == f[i] + 1) {
                        res.add(w[i]);
                        k = i;
                        break;
                    }
                }
            }
            return res;
        }
    }

    /**
     * 21ms
     * T = n^2
     * S = n
     */
    class Sol_Dp_one_time {
        public List<Integer> largestDivisibleSubset(int[] A) {
            List<Integer> ans = new ArrayList<>();

            if (A == null || A.length == 0) {
                return ans;
            }
            int len = A.length, maxIdx = 0;

            int[] f = new int[len];
            int[] last = new int[len];
            Arrays.fill(last, -1);


            Arrays.sort(A);
            for (int i = 0; i < len; i++) {
                f[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (A[i] % A[j] == 0 && (f[j] + 1) > f[i]) {
                        f[i] = f[j] + 1;
                        last[i] = j;
                    }
                }
                if (f[i] > f[maxIdx]) {
                    maxIdx = i;
                }
            }

            for (int i = maxIdx; i != -1; i = last[i]) {
                // reverse output
                ans.add(A[i]);
            }

            return ans;
        }
    }
}
