package leet._1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class _47_permutations2 {
    //TODO
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] st;

    public List<List<Integer>> permuteUnique(int[] nums) {
        st = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    void dfs(int[] nums, int u) {
        if (u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!st[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && !st[i - 1]) {
                    continue;
                }
                st[i] = true;
                path.add(nums[i]);
                dfs(nums, u + 1);
                path.remove(path.size() - 1);
                st[i] = false;
            }
        }
    }
}
