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
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

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
