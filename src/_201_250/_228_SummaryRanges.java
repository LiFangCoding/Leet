package _201_250;

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
    public static void main(String[] args) {
        _228_SummaryRanges test = new _228_SummaryRanges();
        int[] A = new int[]{0, 1, 2, 4, 5, 7};
        System.out.println(test.summaryRanges(A));
    }

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
