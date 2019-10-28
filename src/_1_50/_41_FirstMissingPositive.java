package _1_50;

import java.util.Arrays;

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
     * T = O(n)
     * S = O(1)
     *
     * (桶排序) O(n) Time, O(1)Space
     * 不用额外空间的桶排序：保证1出现在nums[0]的位置上，2出现在nums[1]的位置上，…，n出现在nums[n-1]的位置上，其他的数字不管。例如[3,4,-1,1]将被排序为[1,-1,3,4]
     * 遍历nums，找到第一个不在应在位置上的1到n的数。例如，排序后的[1,-1,3,4]中第一个 nums[i] != i + 1 的是数字2（注意此时i=1）。
     * 时间复杂度分析：代码中第二层while循环，每循环一次，会将一个数放在正确的位置上，所以总共最多执行 nn 次，所以总时间复杂度 O(n)O(n)。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 1;
        }

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // make sure the i is swapped to correct position.
            if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
                i--;
            }
        }

        for (int i = 0; i < len; i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        _41_FirstMissingPositive test = new _41_FirstMissingPositive();
        int[] A = {3, 4, -1, -1};
        System.out.println(test.firstMissingPositive(A));
    }
    /**
     * T = O(n^2)
     * S = O(1)
     * @param A
     * @return
     */
    public int firstMissingPositive_bruteForce(int[] A) {
        for (int i = 1; i <= A.length + 1; i++) {
            for(int j = 0; j < A.length; j++){
                if(A[j] == i) {
                    break;
                }
                //找到最后一位也不是，返回i
                if(j == A.length - 1 && A[j] != i) {
                    return i;
                }
            }
        }
        //数组为空的情况
        return 1;
    }
}
