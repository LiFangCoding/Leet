package leet._251_300;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class _289_GameOfLife {
    class Sol_ac {
        public void gameOfLife(int[][] board) {
            // n rows, m cols
            if (board.length == 0 || board[0].length == 0) {
                return;
            }

            // live1, dead 0. use the second digit to store
            int n = board.length, m = board[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int live = 0;

                    for (int x = Math.max(0, i - 1); x <= Math.min(n - 1, i + 1); x++) {
                        for (int y = Math.max(0, j - 1); y <= Math.min(m - 1, j + 1); y++) {
                            if (x == i && y == j) continue;
                            if ((board[x][y] & 1) == 1) {
                                live++;
                            }
                        }
                    }
                    int cur = board[i][j] & 1, next = 0;
                    if (cur == 1) {
                        if (live < 2 || live > 3) next = 0;
                        else next = 1;
                    } else {
                        if (live == 3) next = 1;
                        else next = 0;
                    }
                    // System.out.println("i is " + i + ", j is " + j + ", val is " + board[i][j]);
                    board[i][j] |= next << 1;
                    // System.out.println("i is " + i + ", j is " + j + ", val is " + board[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] >>= 1;
                }
            }
        }
    }

    class Sol_inPlace {
        // before live and after is live 2.
        int live = 1, die = 0, liveTodie = 2, dieToLive = -1;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        public void gameOfLife(int[][] board) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
                return;
            }

            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = getVal(board, i, j);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = (board[i][j] == live || board[i][j] == dieToLive) ? live : die;
                }
            }
        }

        private int getVal(int[][] board, int x, int y) {
            int liveCnt = 0;

            for (int i = 0; i < dx.length; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length) {
                    int newVal = board[newx][newy];
                    if (newVal == live || newVal == liveTodie) {
                        liveCnt++;
                    }
                }
            }

            if (board[x][y] == live) {
                if (liveCnt < 2 || liveCnt > 3) {
                    return liveTodie;
                } else {
                    return live;
                }
            }

            // dead cell
            return liveCnt == 3 ? dieToLive : die;
        }
    }

    /**
     * 0ms
     * T = m * n
     * S = m * n
     */
    class Sol_Using_Extra_Space {
        int live = 1, die = 0;
        int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };

        public void gameOfLife(int[][] board) {
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
                return;
            }

            int rows = board.length;
            int cols = board[0].length;

            int[][] cloned = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    cloned[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    board[i][j] = getVal(cloned, i, j);
                }
            }
        }

        private int getVal(int[][] board, int x, int y) {
            int liveCnt = 0;

            for (int i = 0; i < dx.length; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length) {
                    int newVal = board[newx][newy];
                    if (newVal == live) {
                        liveCnt++;
                    }
                }
            }

            if (board[x][y] == live) {
                if (liveCnt < 2 || liveCnt > 3) {
                    return die;
                } else {
                    return live;
                }
            }

            // dead cell
            return liveCnt == 3 ? live : die;
        }
    }
}
