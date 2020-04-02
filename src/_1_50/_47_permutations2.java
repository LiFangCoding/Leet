package _1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class _47_permutations2 {
    List<List<Integer>> ans;
    List<Integer> cur;
    boolean[] marked;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();
        marked = new boolean[nums.length];

        Arrays.sort(nums);
        dfs(nums);
        return ans;
    }

    private void dfs(int[] nums) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Same number can be only used once at each depth.
            if (i > 0 && nums[i] == nums[i - 1] && !marked[i - 1]) {
                continue;
            }
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
        int[] A = {1,1,2,2};
        _47_permutations2 test = new _47_permutations2();

        System.out.println(test.permuteUnique(A));
    }
}
