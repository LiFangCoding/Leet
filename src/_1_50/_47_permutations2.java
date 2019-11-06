package _1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class _47_permutations2 {
    public List<List<Integer>> permuteUnique(int[] A) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[A.length];

        if (A == null || A.length == 0) {
            return res;
        }

        Arrays.sort(A);
        helper(A, used, path, res);
        return res;
    }

    private void helper(int[] A, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        // base case
        if (path.size() == A.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(A[i]);
            helper(A, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
            // As long as the num is same, do not make it
            while (i + 1 < A.length && A[i] == A[i + 1]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,1,2,2};
        _47_permutations2 test = new _47_permutations2();

        System.out.println(test.permuteUnique(A));
    }

    // Has bug.
    // If we swap here, it can be 9,0, 1, 0. It will break the point that A[i] == A[i - 1]
    private void helper_bug(int[] A, int start, List<Integer> path, List<List<Integer>> res) {
        if (start == A.length) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < A.length; i++) {
            if (i != start && A[i] == A[i - 1]) {
                continue;
            }

            swap(A, i, start);
            path.add(A[start]);
            helper_bug(A, start + 1, path, res);
            swap(A, i, start);
            path.remove(path.size() - 1);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
