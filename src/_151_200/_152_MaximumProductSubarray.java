package _151_200;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class _152_MaximumProductSubarray {
    public static void main(String[] args) {
        _152_MaximumProductSubarray test = new _152_MaximumProductSubarray();
        int[] A = new int[]{2, 3, -2, 4};

        System.out.println(test.maxProduct(A));

        A = new int[]{-2, 0, -1};
        System.out.println(test.maxProduct(A));
    }

    /**
     * f[i] means the end index ith, maxProduct
     * <p>
     * f[i] = max {A[i], f[i] = A[i] * max(f[i - 1]) }
     * g[i] = min {A[i] < 0, f[i]  = A[i] * Minf[i-1]
     *
     * @param A
     * @return
     */
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        int[] max = new int[2];
        int[] min = new int[2];

        min[0] = max[0] = A[0];
        int res = A[0];

        for (int i = 1; i < len; i++) {
            max[i % 2] = Math.max(A[i], A[i] > 0 ? A[i] * max[(i - 1) % 2] : A[i] * min[(i - 1) % 2]);
            min[i % 2] = Math.min(A[i], A[i] > 0 ? A[i] * min[(i - 1) % 2] : A[i] * max[(i - 1) % 2]);

            res = Math.max(res, max[i % 2]);
        }

        return res;
    }
}
