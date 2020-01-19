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
    List<Integer> path;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        path = new ArrayList<>();
        res = new ArrayList<>();

        helper(1, k, n);
        return res;
    }

    private void helper(int start, int k, int n) {
        if (n < 0 || path.size() > k) {
            return;
        }

        if (path.size() == k && n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            helper(i + 1, k, n - i);
            path.remove(path.size() - 1);
        }
    }
}
