package _1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class _39_CombinationSum {
    List<List<Integer>> res;
    List<Integer> path;

    public static void main(String[] args) {
        _39_CombinationSum test = new _39_CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> res = test.combinationSum(candidates, target);
        System.out.println(Arrays.deepToString(res.toArray()));

        System.out.println(test.path);
        System.out.println(test.res);

        List<List<Integer>> res1 = test.combinationSum(candidates, target);
        System.out.println(Arrays.deepToString(res1.toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        helper(candidates, target, 0);
        return res;
    }

    /**
     * Without start index,
     * for each method, finally add correct path into res
     * candidates = [2,3,6,7], target = 7,
     * res = {[2,2,3], [2,3,2], [3,2,2], 7}. Not correct.
     */
    private void helper(int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            path.add(num);
            helper(candidates, target - num, i);
            path.remove(path.size() - 1);
        }
    }
}
