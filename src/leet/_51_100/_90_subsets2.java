package leet._51_100;

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

    public List<List<Integer>> subsetsWithDup(int[] A) {
        ans = new ArrayList<>();
        cur = new ArrayList<>();

        Arrays.sort(A);
        dfs(A, 0);
        return ans;
    }

    // [1, 2, 2]
    // [] [1] [1,2] [1,2,2] [2] [2,2]
    private void dfs(int[] A, int start) {
        // here is add cur
        ans.add(new ArrayList<>(cur));

        for (int i = start; i < A.length; i++) {
            // skip duplicates. Anything duplicates in the range will be throw away
            if (i != start && A[i] == A[i - 1]) {
                continue;
            }

            cur.add(A[i]);
            dfs(A, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
