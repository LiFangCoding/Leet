package _201_250;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example: 
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
public class _209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        _209_MinimumSizeSubarraySum test = new _209_MinimumSizeSubarraySum();
        int[] A = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(test.minSubArrayLen(7, A));
    }

    public int minSubArrayLen_shorter(int target, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (int l = 0, r = 0; r < A.length; r++) {
            sum += A[r];

            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= A[l];
                l++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen(int target, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;

        while (r < A.length) {
            sum += A[r];

            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= A[l];
                l++;
            }

            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
