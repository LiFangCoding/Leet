/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output:  [1,2,4,7,5,3,6,8,9]
 */
public class _498_Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0) {
            return new int[0];
        }
        int m = M.length, n = M[0].length;

        int[] ans = new int[m * n];

        boolean upDir = true;

        int cnt = 0;
        for (int i = 0; i <= m + n - 2; i++) {
            // better make the x,y +1, -1 write down for updir or not to avoid error
            if (upDir) {
                int x = Math.min(i, m - 1);
                int y = i - x;

                while (x >= 0 && y < n) {
                    ans[cnt++] = M[x--][y++];
                }
            } else {
                // important. When it is large enough, make y choose the max value can
                int y = Math.min(i, n - 1);
                int x = i - y;

                while (x < m && y >= 0) {
                    ans[cnt++] = M[x++][y--];
                }
            }
            upDir = !upDir;
        }

        return ans;
    }
}
