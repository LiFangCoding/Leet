package _1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class _40_CombinationSum2 {
    List<List<Integer>> res;
    List<Integer> path;

    public static void main(String[] args) {
        _40_CombinationSum2 test = new _40_CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> res = test.combinationSum2(candidates, target);
        System.out.println(Arrays.deepToString(res.toArray()));

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return res;
    }

    private void helper(int[] candidates, int target, int start) {
        // base condition
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        int len = candidates.length;
        for (int i = start; i < len; i++) {
            /**
             * Because we just care in this level, do not pick the num which can be same.
             * So it starts from start position.
             */
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            int num = candidates[i];
            path.add(num);
            helper(candidates, target - num, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
