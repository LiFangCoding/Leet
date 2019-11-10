package _1_50;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        helper(nums, used, path, res);
        return res;
    }

    private void helper(int[] A, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == A.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(A[i]);
            helper(A, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    /**
     * better do not use swap. Because swap will break the relationship that sorted array the same are grouped.
     */
//    private void helper(int[] nums, int start) {
//        if (path.size() == nums.length) {
//            res.add(new ArrayList<>(path));
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            swap(nums, i, start);
//            path.add(nums[start]);
//            helper(nums, start + 1);
//            swap(nums, i, start);
//            path.remove(path.size() - 1);
//        }
//    }
//
//    private void swap(int[] A, int i, int j) {
//        int temp = A[i];
//        A[i] = A[j];
//        A[j] = temp;
//    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        _46_Permutations test = new _46_Permutations();

        System.out.println(test.permute(nums));
    }
}
