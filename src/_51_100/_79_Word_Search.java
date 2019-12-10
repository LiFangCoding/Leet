package _51_100;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class _79_Word_Search {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        if (m == 0 || n == 0) {
            return false;
        }

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, visited, "", board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(int x, int y, boolean[][] visited, String chosen, char[][] board, String word) {
        if (board[x][y] != word.charAt(chosen.length())) {
            return false;
        }
        /**
         * check current sol is ok
         */
        if (chosen.length() == word.length() - 1) {
            return true;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int m = board.length;
        int n = board[0].length;

        /**
         * cannot go back.
         * check further has solution
         */
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (visited[newx][newy] || newx < 0 || newx >= m || newy < 0 || newy >= n) {
                continue;
            }

            if (helper(newx, newy, visited, chosen + board[x][y], board, word)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
