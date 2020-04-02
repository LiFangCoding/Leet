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
    List<Integer> cur;
    List<List<Integer>> ans;
    boolean[] marked;

    public List<List<Integer>> permute(int[] nums) {
        // remember to initialize the marked boolean array
        cur = new ArrayList<>();
        ans = new ArrayList<>();
        marked = new boolean[nums.length];

        dfs(nums);
        return ans;
    }

    private void dfs(int[] nums) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                cur.add(nums[i]);
                dfs(nums);
                cur.remove(cur.size() - 1);
                marked[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        _46_Permutations test = new _46_Permutations();

        System.out.println(test.permute(nums));
    }
}
