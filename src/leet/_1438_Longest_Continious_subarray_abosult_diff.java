package leet;

import java.util.PriorityQueue;

/**
 * Given an array of integers nums and an integer limit, return the size of the longest continuous subarray such that the absolute difference between any two elements is less than or equal to limit.
 * <p>
 * In case there is no subarray satisfying the given condition return 0.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * Example 2:
 * <p>
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 * <p>
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 */
public class _1438_Longest_Continious_subarray_abosult_diff {
    public int longestSubarray(int[] A, int limit) {
        // important is to after remove, the difference between the max one and min one. nlogk.
        // we just need in window, the max and min. Then remove, find what is next max, or min
        if (A == null || A.length == 0) {
            return 0;
        }

        int ans = 0;
        int len = A.length;
        // we can use treemap for the ceiling and floow also.
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for (int l = 0, r = 0; r < len; r++) {
            if (maxPq.isEmpty() || minPq.isEmpty()) {
                ans = 1;
                maxPq.add(A[r]);
                minPq.add(A[r]);
            } else {
                int cur = A[r];
                // System.out.printf("the max is %d, the min is %d, the l is %d, the r is %d&n", max, min, l, r);

                // if not meet the requirement. remove the l
                while (!(Math.abs(cur - maxPq.peek()) <= limit && Math.abs(cur - minPq.peek()) <= limit)) {
                    maxPq.remove(A[l]);
                    minPq.remove(A[l]);
                    l++;

                    if (maxPq.isEmpty()) {
                        break;
                    }
                }

                ans = Math.max(ans, r - l + 1);
                maxPq.add(A[r]);
                minPq.add(A[r]);

                //                 if (Math.abs(cur - max) <= limit && Math.abs(cur - min) <= limit) {
//                     // System.out.printf("l is %d, r is %d", l, r);
//                     ans = Math.max(ans, r - l + 1);
//                 } else {
//                     while (true) {
//                     maxPq.remove(A[l]);
//                     minPq.remove(A[l]);
//                     l++;

                //                     if (maxPq.isEmpty()) {
//                         // System.out.printf("empty l is %d", l);
//                         break;
//                     }

                //                     max = maxPq.peek();
//                     min = minPq.peek();

                //                     if (Math.abs(cur - max) <= limit && Math.abs(cur - min) <= limit) {
//                         // System.out.printf("valid l is %d", l);
//                         break;
//                     }
//                 }
//                 }

                //                 // make sure maxPq is not empty
//                 // here inRange is not excetution again. It is a boolean calculated value
//                 // cannot have l < r here. Else always do it

                //                 // here need add
//                 maxPq.add(A[r]);
//                 minPq.add(A[r]);
            }
        }

        return ans;
    }
}
