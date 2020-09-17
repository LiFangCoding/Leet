package leet._201_250;

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

    class Sol_simple {
        class Trie {
            Node root;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                root = new Node();
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
                Node p = root;
                for (char c : word.toCharArray()) {
                    int u = c - 'a';
                    if (p.son[u] == null) {
                        p.son[u] = new Node();
                    }
                    p = p.son[u];
                }
                p.isEnd = true;
            }

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                Node p = root;
                for (char c : word.toCharArray()) {
                    int u = c - 'a';
                    if (p.son[u] == null)
                        return false;
                    p = p.son[u];
                }

                return p.isEnd;
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                Node p = root;
                for (char c : prefix.toCharArray()) {
                    int u = c - 'a';
                    if (p.son[u] == null)
                        return false;
                    p = p.son[u];
                }
                return true;
            }

            class Node {
                boolean isEnd = false;
                Node[] son = new Node[26];
            }
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public _208_ImplementTrie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        _208_ImplementTrie test = new _208_ImplementTrie();
        test.insert("app");
        test.insert("appe");
        test.search("app");
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            // important: else override the isEnd to be false
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }

        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }

            cur = cur.children[idx];
        }

        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        // be careful. Do not change the isEnd for other data during insert
        boolean isEnd = false;
    }

    class Sol_before {
        Node root;

        /**
         * Initialize your data structure here.
         */
        public Sol_before() {
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
}
