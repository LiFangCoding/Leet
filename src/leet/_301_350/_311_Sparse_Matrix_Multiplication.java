package leet._301_350;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * <p>
 * You may assume that A's column number is equal to B's row number.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * A = [
 * [ 1, 0, 0],
 * [-1, 0, 3]
 * ]
 * <p>
 * B = [
 * [ 7, 0, 0 ],
 * [ 0, 0, 0 ],
 * [ 0, 0, 1 ]
 * ]
 * <p>
 * Output:
 * <p>
 * |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 * | 0 0 1 |
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-matrix-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _311_Sparse_Matrix_Multiplication {
    /**
     * 0ms
     */
    class Sol_revise {
        public int[][] multiply(int[][] A, int[][] B) {
            int n = A.length;
            int m = B[0].length;
            int t = A[0].length;
            int[][] C = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int k = 0; k < t; k++) {
                    if (A[i][k] == 0) {
                        continue;
                    }
                    for (int j = 0; j < m; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
            return C;
        }
    }

    /**
     * 0ms
     */
    class Sol_common {
        public int[][] multiply(int[][] A, int[][] B) {
            // Write your code here
            int n = A.length;
            int m = A[0].length;
            int k = B[0].length;

            int[][] C = new int[n][k];

            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    if (A[i][j] != 0)
                        for (int l = 0; l < k; ++l)
                            C[i][l] += A[i][j] * B[j][l];
            return C;
        }
    }
}
