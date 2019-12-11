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
    public List<List<Integer>> subsetsWithDup(int[] A) {
        List<List<Integer>> res = new ArrayList<>();

        if (A == null || A.length == 0) {
            return res;
        }

        Arrays.sort(A);
        helper(0, A, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int start, int[] A, ArrayList<Integer> chosen, List<List<Integer>> res) {
        res.add(new ArrayList<>(chosen));

        for (int i = start; i < A.length; i++) {
            if (i != start && A[i] == A[i - 1]) {
                continue;
            }
            chosen.add(A[i]);
            helper(i + 1, A, chosen, res);
            chosen.remove(chosen.size() - 1);
        }
    }
}
