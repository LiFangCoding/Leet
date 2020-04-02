package _51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class _90_subsets2 {
    List<List<Integer>> ans;
    List<Integer> cur;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();

        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }

    // [1, 2, 2]
    // [] [1] [1,2] [1,2,2] [2] [2,2]
    private void dfs(int[] nums, int s) {
        // here is add cur
        ans.add(new ArrayList<>(cur));

        for (int i = s; i < nums.length; i++) {
            if (i != s && nums[i] == nums[i - 1]) {
                continue;
            }

            cur.add(nums[i]);
            dfs(nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
