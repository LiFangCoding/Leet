package leet._1_50;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class _41_FirstMissingPositive {
    /**
     * 1ms
     * T = O(n)
     * S = O(1)
     * <p>
     * (桶排序) O(n) Time, O(1)Space
     * 不用额外空间的桶排序：保证1出现在nums[0]的位置上，2出现在nums[1]的位置上，…，n出现在nums[n-1]的位置上，其他的数字不管。例如[3,4,-1,1]将被排序为[1,-1,3,4]
     * 遍历nums，找到第一个不在应在位置上的1到n的数。例如，排序后的[1,-1,3,4]中第一个 nums[i] != i + 1 的是数字2（注意此时i=1）。
     * 时间复杂度分析：代码中第二层while循环，每循环一次，会将一个数放在正确的位置上，所以总共最多执行 n 次，所以总时间复杂度 O(n)。
     */
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }

        // map val -> val - 1. if val >= 1 && val <= len
        // map val = idx + 1.
        int len = A.length;
        // 1,2... n
        for (int i = 0; i < len; i++) {
            // if A[i] == idx + 1
            int val = A[i];
            int idx = val - 1;

            if (idx < 0 || idx >= len) {
                continue;
            }

            if (A[idx] == idx + 1) {
                continue;
            }

            swap(A, i, idx);
            i--;
        }

        for (int i = 0; i < len; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
