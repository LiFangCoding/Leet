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
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        // need initilize here
        int m = board.length, n = board[0].length;

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if (board[i][j] == word.charAt(0)) {
                if (search(board, i, j, word, 0)) {
                    return true;
                }
                // }
            }
        }

        return false;
    }

    // search from one point, see if it is ok
    private boolean search(char[][] board, int x, int y, String word, int idx) {
        // here is word.length(), not word.length
        // cannot think it will go further. If == len.  [["a"]]  "a". it is false. exp is true
        if (idx == word.length() - 1) {
            return board[x][y] == word.charAt(idx);
        }

        if (board[x][y] != word.charAt(idx)) {
            return false;
        }

        // mark as visited, need to bracktrack. no nothing change
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int newx = x + dx[k];
            int newy = y + dy[k];

            if (newx < 0 || newx >= board.length || newy < 0 || newy >= board[0].length) {
                continue;
            }

            if (!visited[newx][newy]) {
                if (search(board, newx, newy, word, idx + 1)) {
                    return true;
                }
            }
        }

        visited[x][y] = false;
        return false;
    }
}
