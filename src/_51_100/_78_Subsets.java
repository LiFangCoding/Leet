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

    List<Integer> cur;
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();

        dfs(nums, 0);
        return ans;
    }

    // [1,2,3]
    // ans = [] [1] [1,2] [1,2,3] [1,3]  [2] [2,3]
    private void dfs(int[] nums, int s) {
        ans.add(new ArrayList<>(cur));

        for (int i = s; i < nums.length; i++) {
            // here is to add nums[i], not nums[s]
            cur.add(nums[i]);
            dfs(nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
