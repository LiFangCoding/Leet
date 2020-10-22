package leet._401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *  
 * <p>
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class _417_Pacific_Atlantic_Water_Flow {
    class Sol_ac {
        // 遍历一下哪些格子可以从太平洋到达
        // 哪些格子可以从大西洋到
        // 看重复。 两遍遍历就行
        // 开两个二维数组也可以
        int n;
        int m;
        int[][] w;
        int[][] st;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        void dfs(int x, int y, int t) {
            // already visisted
            if ((st[x][y] & t) != 0) {
                return;
            }

            st[x][y] |= t;
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < n && b >= 0 && b < m && w[a][b] >= w[x][y]) {
                    dfs(a, b, t);
                }
            }
        }

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            w = matrix;
            if (w == null || w.length == 0 || w[0].length == 0) return new ArrayList<>();

            n = w.length;
            m = w[0].length;
            st = new int[n][m];

            for (int i = 0; i < n; i++) dfs(i, 0, 1);
            for (int i = 0; i < m; i++) dfs(0, i, 1);
            for (int i = 0; i < n; i++) dfs(i, m - 1, 2);
            for (int i = 0; i < m; i++) dfs(n - 1, i, 2);

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (st[i][j] == 3) {
                        List<Integer> t = new ArrayList<>();
                        t.add(i);
                        t.add(j);
                        res.add(t);
                    }
                }
            }
            return res;
        }
    }

    class Sol_two_boolean_array {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new ArrayList<>();
            }

            List<List<Integer>> ans = new ArrayList<>();

            int m = matrix.length;
            int n = matrix[0].length;

            boolean[][] canReachP = new boolean[m][n];
            boolean[][] canReachA = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                dfs(matrix, canReachP, i, 0);
                dfs(matrix, canReachA, i, n - 1);
            }

            for (int i = 0; i < n; i++) {
                dfs(matrix, canReachP, 0, i);
                dfs(matrix, canReachA, m - 1, i);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canReachP[i][j] && canReachA[i][j]) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        ans.add(temp);
                    }
                }
            }

            return ans;
        }

        private void dfs(int[][] matrix, boolean[][] canReach, int x, int y) {
            if (canReach[x][y]) {
                return;
            }

            canReach[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[x][y] <= matrix[nx][ny]) {
                    dfs(matrix, canReach, nx, ny);
                }
            }
        }
    }
}
