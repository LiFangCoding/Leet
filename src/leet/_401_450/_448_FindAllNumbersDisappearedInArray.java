package leet._401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class _448_FindAllNumbersDisappearedInArray {

    /**
     * 7ms
     * T = n
     * S = 1
     */
    class Sol_mark {
        /**
         * 我们需要知道数组中存在的数字，由于数组的元素取值范围是 [1, N]，所以我们可以不使用额外的空间去解决它。
         * 我们可以在输入数组本身以某种方式标记已访问过的数字，然后再找到缺失的数字。
         * <p>
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-de-shu-zi-2/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        public List<Integer> findDisappearedNumbers(int[] A) {
            int len = A.length;
            for (int i = 0; i < len; i++) {
                int newIdx = Math.abs(A[i]) - 1;

                if (A[newIdx] > 0) {
                    A[newIdx] *= -1;
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (A[i] > 0) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }
    }

    /**
     * 6ms
     * T = n
     * S = 1
     */
    class Sol_Swap {
        // [1,3,3] -> [2]
        public List<Integer> findDisappearedNumbers(int[] A) {
            List<Integer> ans = new ArrayList<>();

            // in A, the idx as i has value as i + 1. A[i] = i + 1
            // [1,2,3]

            int len = A.length;
            for (int i = 0; i < len; i++) {
                int idx = A[i] - 1;
                // already filled with correct num.
                if (A[idx] == idx + 1 || A[i] == i + 1) {
                    continue;
                }

                swap(A, i, idx);
                // after swap. The A[idx] = idx + 1
                i--;
            }

            // find the missing num. NOt A[i]. It is i + 1
            for (int i = 0; i < len; i++) {
                if (A[i] != i + 1) {
                    ans.add(i + 1);
                }
            }

            return ans;
        }

        private void swap(int[] A, int l, int r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
        }
    }
}
