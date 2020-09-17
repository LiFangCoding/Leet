package leet._151_200;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class _189_RotateArray {
    class Sol_reverse {
        public void rotate(int[] nums, int k) {
            // how large is k. k % n
            if (nums == null || nums.length == 0)
                return;

            int n = nums.length;
            // important
            k %= n;

            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int l, int r) {
            while (l < r) {
                int t = nums[l];
                nums[l++] = nums[r];
                nums[r--] = t;
            }
        }
    }

    public void rotate_circular_array(int[] A, int k) {
        if (A == null || A.length == 0) {
            return;
        }

        int len = A.length;
        k %= len;

        int count = 0;
        for (int i = 0; count < len; i++) {
            int cur = i;
            int prev = A[i];
            do {
                int next = (cur + k) % len;
                int temp = A[next];
                A[next] = prev;
                prev = temp;
                cur = next;
                count++;
            } while (i != cur);
        }
    }
}
