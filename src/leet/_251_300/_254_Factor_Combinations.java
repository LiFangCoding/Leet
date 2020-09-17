package leet._251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * <p>
 * Note:
 * <p>
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Example 1:
 * <p>
 * Input: 1
 * Output: []
 * Example 2:
 * <p>
 * Input: 37
 * Output:[]
 * Example 3:
 * <p>
 * Input: 12
 * Output:
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 * Example 4:
 * <p>
 * Input: 32
 * Output:
 * [
 * [2, 16],
 * [2, 2, 8],
 * [2, 2, 2, 4],
 * [2, 2, 2, 2, 2],
 * [2, 4, 4],
 * [4, 8]
 * ]
 */
public class _254_Factor_Combinations {

    List<List<Integer>> res;
    List<Integer> path;

    public static void main(String[] args) {
        _254_Factor_Combinations test = new _254_Factor_Combinations();
        System.out.println(test.getFactors(12));
    }

    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        dfs(n, 2);
        return res;
    }

    /**
     * * Factors should be greater than 1 and less than n.
     *
     * @param n
     * @param start
     */
    private void dfs(int n, int start) {
        if (n <= 0) {
            return;
        }

        if (n == 1) {
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        /**
         * else cannot find the n / i is 1.
         */
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                dfs(n / i, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
