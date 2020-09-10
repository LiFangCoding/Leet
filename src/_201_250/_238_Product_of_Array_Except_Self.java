package _201_250;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class _238_Product_of_Array_Except_Self {
    class Sol_acwing {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;

            int res[] = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }

            // s means suffix product
            for (int i = n - 1, s = 1; i >= 0; i--) {
                res[i] *= s;
                s *= nums[i];
            }

            return res;
        }
    }

    /**
     * 1ms
     * T = n
     * S = n
     */
    class Sol_use_array {
        public int[] productExceptSelf(int[] A) {
            if (A == null || A.length == 0) {
                return new int[0];
            }

      int len = A.length;
      // f[i] means product of [0,i)
      int[] f = new int[A.length];
      f[0] = 1;
      // g[i] means product of (i, len - 1]
      int[] g = new int[A.length];
      g[len - 1] = 1;

      for (int i = 1; i < len; i++) {
        f[i] = f[i - 1] * A[i - 1];
      }

      for (int i = len - 2; i >= 0; i--) {
        g[i] = g[i + 1] * A[i + 1];
      }

      int[] ans = new int[len];
      for (int i = 0; i < len; i++) {
        ans[i] = f[i] * g[i];
      }

      return ans;
    }
  }
}
