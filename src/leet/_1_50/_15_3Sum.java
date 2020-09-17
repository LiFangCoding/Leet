package leet._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _15_3Sum {
    //TODO
    public List<List<Integer>> threeSum(int[] A) {
        List<List<Integer>> ans = new ArrayList<>();

        if (A == null || A.length == 0) {
            return ans;
        }

        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            /**
             * skip duplicate triples with the same first number
             */
            if (i >= 1 && A[i] == A[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = A.length - 1;

            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(A[i], A[left], A[right]));

                    left++;
                    right--;

                    // skip duplicate pairs with the same left
                    while (left < right && A[left] == A[left - 1]) {
                        left++;
                    }
                    // skip duplicate pairs with the same right
                    while (right > left && A[right] == A[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
