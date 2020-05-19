package _1_50;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _1_twoSum {
    public static int[] twoSum(int[] A, int target) {
        // value -> index
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < A.length; i++) {
            int x = target - A[i];

            if (map.containsKey(x)) {
                ans[0] = map.get(x);
                ans[1] = i;
                break;
            } else {
                map.put(A[i], i);
            }
        }

        return ans;
    }
}
