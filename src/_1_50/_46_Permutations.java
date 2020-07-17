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
    //TODO
    List<Integer> cur;
    List<List<Integer>> ans;
    boolean[] marked;

    public List<List<Integer>> permute(int[] A) {
        // remember to initialize the marked boolean array
        cur = new ArrayList<>();
        ans = new ArrayList<>();
        marked = new boolean[A.length];

        dfs(A);
        return ans;
    }

    private void dfs(int[] A) {
        if (cur.size() == A.length) {
            ans.add(new ArrayList<>(cur));
        }

        for (int i = 0; i < A.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                cur.add(A[i]);
                dfs(A);
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
