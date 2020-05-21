package _551_600;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * <p>
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *  
 * <p>
 * Constraints:
 * <p>
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class _560_SubArray_Sum_EqualsK {
    public int subarraySum(int[] A, int k) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int curSum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : A) {
            curSum += num;
            // find how many that sum occur before cur idx
            ans += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return ans;
    }
}
