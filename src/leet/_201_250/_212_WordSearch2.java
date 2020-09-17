package leet._201_250;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 *  
 * <p>
 * Note:
 * <p>
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 */
public class _212_WordSearch2 {
    /**
     * 23 ms
     * T = M * 4 * 3 ^ (L - 1)
     * 其中M 是二维网格中的单元格数，L 是单词的最大长度。
     * https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode/
     * https://www.acwing.com/solution/content/318/
     */
    class Sol_new {
        Node root;
        Set<Integer> ids = new HashSet<>();
        char[][] g;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        void insert(String word, int id) {
            Node p = root;
            for (char c : word.toCharArray()) {
                int u = c - 'a';
                if (p.son[u] == null)
                    p.son[u] = new Node();
                p = p.son[u];
            }
            p.id = id;
        }

        public List<String> findWords(char[][] board, String[] words) {
            g = board;
            root = new Node();
            for (int i = 0; i < words.length; i++)
                insert(words[i], i);

            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    int u = g[i][j] - 'a';
                    if (root.son[u] != null) {
                        dfs(i, j, root.son[u]);
                    }
                }
            }

            List<String> res = new ArrayList<>();
            for (int id : ids)
                res.add(words[id]);
            return res;
        }

        void dfs(int x, int y, Node p) {
            if (p.id != -1) {
                ids.add(p.id);
            }

            char t = g[x][y];
            g[x][y] = '.';
            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a >= 0 && a < g.length && b >= 0 && b < g[0].length && g[a][b] != '.') {
                    int u = g[a][b] - 'a';
                    if (p.son[u] != null) {
                        dfs(a, b, p.son[u]);
                    }
                }
            }
            g[x][y] = t;
        }

        class Node {
            int id = -1;
            Node[] son = new Node[26];
        }
    }
}
