package leet._101_150;

import java.util.Arrays;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class _130_Surrounded_Regions {

    boolean[][] visited;
    int m;
    int n;

    public static void main(String[] args) {
        _130_Surrounded_Regions test = new _130_Surrounded_Regions();
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };

        test.solve(board);

        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        /**
         * !!! check board.length
         */
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;

        visited = new boolean[m][n];

        /**
         * first row
         */
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x >= m || x < 0 || y >= n || y < 0 || visited[x][y]) {
            return;
        }

        if (board[x][y] != 'O') {
            return;
        }

        visited[x][y] = true;
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        for (int i = 0; i < 4; i++) {
            dfs(board, x + dx[i], y + dy[i]);
        }
    }
}
