package _201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class _216_CombinationSum3 {
    List<Integer> cur;
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        cur = new ArrayList<>();
        ans = new ArrayList<>();

        dfs(k, 1, n);
        return ans;
    }

    // k = 3, n = 7
    // [1, 2, 4]
    private void dfs(int k, int s, int target) {
        if (cur.size() == k) {
            if (target == 0) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = s; i <= 9; i++) {
            if (i > target) {
                break;
            }

            cur.add(i);
            dfs(k, i + 1, target - i);
            cur.remove(cur.size() - 1);
        }
    }
}
