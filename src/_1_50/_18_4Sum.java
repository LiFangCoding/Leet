package _1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] A, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (A == null || A.length == 0) {
            return ans;
        }

        Arrays.sort(A);
        for (int i = 0; i < A.length - 3; i++) {
            // skip first value
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            // skip second vaalue
            for (int j = i + 1; j < A.length - 2; j++) {
                if (j > i + 1 && A[j] == A[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = A.length - 1;

                while (left < right) {
                    int sum = A[i] + A[j] + A[left] + A[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        /**
                         * Here is the value not index.
                         */
                        ans.add(Arrays.asList(A[i], A[j], A[left], A[right]));

                        left++;
                        right--;
                        while (left < right && A[left] == A[left - 1]) {
                            left++;
                        }

                        while (right > left && A[right] == A[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
