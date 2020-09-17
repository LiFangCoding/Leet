package leet._1_50;

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
    List<List<Integer>> ans;
    List<Integer> cur;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        // important sort
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    private void dfs(int[] candidates, int start, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // important for duplicates
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            cur.add(candidates[i]);
            // here important to substract the value
            dfs(candidates, i + 1, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
