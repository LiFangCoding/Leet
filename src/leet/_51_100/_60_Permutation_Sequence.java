package leet._51_100;

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
 * @return
 */

public class _60_Permutation_Sequence {
    //TODO: 60

    /**
     * T = n^2
     */
    class Sol_template {
        public String getPermutation(int n, int k) {
            StringBuilder sb = new StringBuilder();
            boolean[] used = new boolean[n];

            k = k - 1;
            int factor = 1;
            for (int i = 1; i < n; i++) {
                factor *= i;
            }

            for (int i = 0; i < n; i++) {
                int index = k / factor;
                k = k % factor;
                for (int j = 0; j < n; j++) {
                    if (used[j] == false) {
                        if (index == 0) {
                            used[j] = true;
                            sb.append((char) ('0' + j + 1));
                            break;
                        } else {
                            index--;
                        }
                    }
                }
                if (i < n - 1) {
                    factor = factor / (n - 1 - i);
                }
            }

            return sb.toString();
        }
    }

    /**
     * 1043ms
     * T = n!
     */
    class Sol_recursion {
        boolean[] marked;
        int cnt;
        String ans;

        public String getPermutation(int n, int k) {
            marked = new boolean[n + 1];
            cnt = 0;

            ans = null;
            search(n, k, "");
            return ans;
        }

        private void search(int n, int k, String path) {
            if (path.length() == n) {
                cnt++;
                if (cnt == k) {
                    ans = path;
                }
                return;
            }

            if (ans != null) {
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (!marked[i]) {
                    marked[i] = true;
                    search(n, k, path + i);
                    marked[i] = false;
                }
            }
        }
    }
}
