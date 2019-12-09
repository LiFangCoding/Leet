package _51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class _78_Subsets {
    public static void main(String[] args) {
        _78_Subsets test = new _78_Subsets();
        int[] A = {1, 2, 3};
        System.out.println(test.subsets(A));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> chosen = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        helper(nums, 0, chosen, res);
        return res;
    }

    /**
     * if we choose 1, then candidates are [2,3]
     * choose 2, candidates are [3]
     */
    public void helper(int[] nums, int start, List<Integer> chosen, List<List<Integer>> res) {
        res.add(new ArrayList<>(chosen));

        for (int i = start; i < nums.length; i++) {
            chosen.add(nums[i]);
            helper(nums, i + 1, chosen, res);
            chosen.remove(chosen.size() - 1);
        }
    }
}
