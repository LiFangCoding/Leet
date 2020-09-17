package leet._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
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
    List<List<Integer>> ans;
    List<Integer> cur;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();

        // to make break
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
            // choose candidates
            if (candidates[i] > target) {
                break;
            }
            cur.add(candidates[i]);
            dfs(candidates, i, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}
