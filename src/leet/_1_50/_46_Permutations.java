package leet._1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class _46_Permutations {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] st;

    public List<List<Integer>> permute(int[] nums) {
        st = new boolean[nums.length];
        dfs(nums, 0);
        return res;
    }

    void dfs(int[] nums, int u) {
        if (u == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (st[i] == false) {
                path.add(nums[i]);
                st[i] = true;
                dfs(nums, u + 1);
                st[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
