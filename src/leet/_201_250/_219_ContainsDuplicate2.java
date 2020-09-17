package leet._201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class _219_ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] A, int k) {
        if (A == null || A.length == 0) {
            return false;
        }

        /**
         * value -> index
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            if (map.containsKey(x) && i - map.get(x) <= k)
                return true;
            map.put(x, i);
        }

        return false;
    }
}
