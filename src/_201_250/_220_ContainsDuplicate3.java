package _201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class _220_ContainsDuplicate3 {
    //TODO: add todo. Need more time to think


    // Get the ID of the bucket from element value x and bucket width w
    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] A, int k, int t) {
        if (t < 0) {
            return false;
        }

        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < A.length; ++i) {
            long m = getID(A[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m)) {
                return true;
            }
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(A[i] - d.get(m - 1)) < w) {
                return true;
            }
            if (d.containsKey(m + 1) && Math.abs(A[i] - d.get(m + 1)) < w) {
                return true;
            }
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long) A[i]);
            if (i >= k) {
                d.remove(getID(A[i - k], w));
            }
        }
        return false;
    }
}
