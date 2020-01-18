package _201_250;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class _208_ImplementTrie {
    Node root;

    /**
     * Initialize your data structure here.
     */
    public _208_ImplementTrie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String s) {
        if (s == null || s.length() == 0) {
            return;
        }

        Node cur = root;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int idx = c - 'a';
            if (cur.childs[idx] == null) {
                cur.childs[idx] = new Node();
            }

            cur = cur.childs[idx];
            if (i == chars.length - 1) {
                cur.isleaf = true;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node lastNode = searchHelper(word);
        return lastNode != null && lastNode.isleaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node lastNode = searchHelper(prefix);
        return lastNode != null;
    }

    /**
     * Use trie to search the string s until last char.
     * Return the node which is last char
     * If not exist, return null
     *
     * @return
     */
    private Node searchHelper(String s) {
        if (s == null || s.length() == 0) {

        }

        Node cur = root;

        char[] chars = s.toCharArray();


        for (char c : chars) {
            int idx = c - 'a';
            if (cur.childs[idx] == null) {
                return null;
            }

            cur = cur.childs[idx];
        }

        return cur;
    }

    public class Node {
        public boolean isleaf = false;
        public Node[] childs = new Node[26];

        public Node() {

        }
    }
}
