package _51_100;

import java.util.ArrayList;
import java.util.List;

public class _60_Permutation_Sequence {
    public static void main(String[] args) {
        _60_Permutation_Sequence test = new _60_Permutation_Sequence();
        System.out.println(test.getPermutation_DFS(3, 3));
    }

    /**
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * <p>
     * Note:
     * <p>
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1:
     * <p>
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     * <p>
     * Input: n = 4, k = 9
     * Output: "2314"
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation_DFS(int n, int k) {
        List<String> res = new ArrayList<>();

        boolean[] visited = new boolean[n + 1];

        helper(n, k, "", res, visited);

        return res.get(k - 1);
    }

    private void helper(int n, int k, String path, List<String> res, boolean[] visited) {
        if (res.size() == k) {
            return;
        }

        if (path.length() == n) {
            res.add(path);
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            helper(n, k, path + i, res, visited);
            visited[i] = false;
        }
    }

    //TODO
    public String getPermutation_Iteration(int n, int k) {
        return "";
    }

    //TODO
    public String getPermutation_2Bits(int n, int k) {
        return "";
    }
}
