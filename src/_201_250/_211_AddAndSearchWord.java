package _201_250;

/**
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class _211_AddAndSearchWord {
    Node root;

    _211_AddAndSearchWord() {
        root = new Node();
    }

    public void addWord(String word) {
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

    /**
     * Returns if the word is in the data structure.
     * A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int start, Node node) {
        if (start == word.length()) {
            return node.isleaf;
        }

        char c = word.charAt(start);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (dfs(word, start + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        } else {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                return false;
            } else {
                return dfs(word, start + 1, node.children[idx]);
            }
        }

        return false;
    }

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
