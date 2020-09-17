package leet._151_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * <p>
 * Example:
 * <p>
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */
public class _163_Missing_Ranges {
    public static void main(String[] args) {
        _163_Missing_Ranges test = new _163_Missing_Ranges();
        int[] A = new int[] { 0, 1, 3, 50, 75 };
        System.out.println(test.findMissingRanges(A, 0, 99));

        A = new int[] { 2147483647 };
        System.out.println(test.findMissingRanges(A, 0, 2147483647));
    }

    public List<String> findMissingRanges_readable(int[] nums, int lower, int upper) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            addRange(ans, lower, upper);
            return ans;
        }

        addRange(ans, lower, (long) nums[0] - 1);

        for (int i = 1; i < nums.length; i++) {
            addRange(ans, (long) nums[i - 1] + 1, (long) nums[i] - 1);
        }
        addRange(ans, (long) nums[nums.length - 1] + 1, upper);

        return ans;
    }

    void addRange(List<String> ans, long st, long ed) {
        if (st > ed) {
            return;
        }
        if (st == ed) {
            ans.add(st + "");
            return;
        }
        ans.add(st + "->" + ed);
    }

    /**
     * !!! Integer overflow
     * [2147483647]
     * 0
     * 2147483647
     * <p>
     * be careful.
     * Input expected:
     * ["0->2147483646"]
     * <p>
     * Input error:
     * ["0->2147483646","-2147483648->2147483647"]
     */
    public List<String> findMissingRanges(int[] A, int _lower, int upper) {
        List<String> res = new ArrayList<>();

        /**
         * !!! avoid integer overflow
         */
        long lower = _lower;

        for (int i = 0; i < A.length; i++) {
            if (lower < A[i]) {
                if (lower == A[i] - 1) {
                    res.add(String.valueOf(lower));
                } else {
                    res.add(lower + "->" + (A[i] - 1));
                }
            }
            /**
             * !!! Important (long) A[i]
             */
            lower = (long) A[i] + 1;
        }

        if (lower == upper) {
            res.add(String.valueOf(lower));
        } else if (lower < upper) {
            res.add(lower + "->" + upper);
        }

        return res;
    }
}
