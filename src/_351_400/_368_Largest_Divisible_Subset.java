package _351_400;

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
    /**
     * 21ms
     * T = n^2
     * S = n
     */
    class Sol_Dp {
        public List<Integer> largestDivisibleSubset(int[] A) {
            int len = A.length, max = 0, end = -1;

            int[] f = new int[len];
            Arrays.fill(f, 1);
            int[] last = new int[len];
            Arrays.fill(last, -1);

            List<Integer> ans = new ArrayList<>();

            Arrays.sort(A);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (A[i] % A[j] == 0 && f[i] <= f[j]) {
                        f[i] = f[j] + 1;
                        last[i] = j;
                    }
                }

                if (f[i] > max) {
                    max = f[i];
                    end = i;
                }
            }

            for (int i = end; i != -1; i = last[i]) {
                // reverse output
                ans.add(A[i]);
            }

            return ans;
        }
    }
}
