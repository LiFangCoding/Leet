package _51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class _77_Combinations {
    public static void main(String[] args) {
        _77_Combinations test = new _77_Combinations();
        System.out.println(test.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    /**
     * !!! this is combinations. Not same with permutation.
     * Need start position
     * No need boolean[] chosen. It is for permutation to see which is chosen.
     */
    public void helper(int n, int k, int start, List<Integer> chosen, List<List<Integer>> res) {
        if (chosen.size() == k) {
            res.add(new ArrayList<>(chosen));
        }

        for (int i = start; i <= n; i++) {
            chosen.add(i);
            helper(n, k, i + 1, chosen, res);
            chosen.remove(chosen.size() - 1);
        }
    }
}
