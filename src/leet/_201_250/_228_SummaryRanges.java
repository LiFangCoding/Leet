package leet._201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * <p>
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 * <p>
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class _228_SummaryRanges {
    class Sol_acwing {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                int j = i + 1;
                while (j < nums.length && nums[j] == nums[j - 1] + 1)
                    j++;
                if (j == i + 1)
                    res.add(String.valueOf(nums[i]));
                else
                    res.add(nums[i] + "->" + nums[j - 1]);
                // i will be i++ in the loop
                i = j - 1;
            }
            return res;
        }
    }

    // verbose
    class Sol {
        public List<String> summaryRanges(int[] A) {
            List<String> res = new ArrayList<>();

            if (A == null || A.length == 0) {
                return res;
            }

            int l = 0;
            int r = 0;

            while (r < A.length) {
                r = l + 1;

                while (r < A.length && A[r] - 1 == A[r - 1]) {
                    r++;
                }

                if (l == r - 1) {
                    res.add(String.valueOf(A[l]));
                } else {
                    res.add(A[l] + "->" + A[r - 1]);
                }

                l = r;
            }

            return res;
        }
    }
}
