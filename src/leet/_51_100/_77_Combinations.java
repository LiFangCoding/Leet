package leet._51_100;

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
    List<List<Integer>> ans;
    List<Integer> cur;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();

        dfs(n, 1, k);
        return ans;
    }

    private void dfs(int n, int start, int k) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // Will not be true. So can ignore it
        // if (cur.size() > k) {
        //     return;
        // }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfs(n, i + 1, k);
            cur.remove(cur.size() - 1);
        }
    }
}
