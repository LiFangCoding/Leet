package _1_50;

import java.util.*;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class _46_Permutations {
    List<Integer> path;
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        path = new ArrayList<>();
        res = new ArrayList<>();

        helper(nums, 0);
        return res;
    }

    // add path to list
    private void helper(int[] nums, int start) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            path.add(nums[start]);
            helper(nums, start + 1);
            swap(nums, i, start);
            path.remove(path.size() - 1);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        _46_Permutations test = new _46_Permutations();

        System.out.println(test.permute(nums));
    }
}
