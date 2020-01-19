package _201_250;

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
    Node root;
    Set<String> set = new HashSet<>();
    List<String> res = new ArrayList<>();
    boolean[][] vt;
    String[] _words;
    int n, m;

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.isleaf = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) {
            return res;
        }

        _words = words;
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        n = board.length;
        m = board[0].length;

        vt = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, root.children[board[i][j] - 'a']);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int x, int y, Node cur) {
        if (cur == null) {
            return;
        }

        vt[x][y] = true;
        if (cur.isleaf) {
            String match =
        }
    }

    //TODO
    public class Node {
        boolean isleaf;
        Node[] children;

        public Node() {
            isleaf = false;
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
}
