package _51_100;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
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
    class Sol_onPlace {
        char[][] g;
        char[] s;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public boolean exist(char[][] board, String word) {
            g = board;
            s = word.toCharArray();
            int n = board.length, m = board[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(i, j, 0)) return true;
                }
            }

            return false;
        }

        boolean dfs(int x, int y, int u) {
            if (g[x][y] != s[u]) return false;
            if (u == s.length - 1) {
                return true;
            }

            char t = g[x][y];
            g[x][y] = '.';
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < g.length && b >= 0 && b < g[0].length && g[a][b] != '.') {
                    if (dfs(a, b, u + 1)) {
                        return true;
                    }
                }
            }
            g[x][y] = t;
            return false;
        }
    }

    class Sol_withMap {
        /**
         * T = n ^ 2 * 3 ^ k
         * 在深度优先搜索中，最重要的就是考虑好搜索顺序。
         * <p>
         * 我们先枚举单词的起点，然后依次枚举单词的每个字母。
         * 过程中需要将已经使用过的字母改成一个特殊字母，以避免重复使用字符。
         * <p>
         * 时间复杂度分析：单词起点一共有 n^2 个，单词的每个字母一共有上下左右四个方向可以选择，
         * 但由于不能走回头路，所以除了单词首字母外，仅有三种选择。所以总时间复杂度是 O(n^2 * 3^k)
         */
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
}
