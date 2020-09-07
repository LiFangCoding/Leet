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
    class WordDictionary {
        class Node {
            boolean isEnd = false;
            Node[] son = new Node[26];
        }

        Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String s) {
            Node p = root;
            for (char c : s.toCharArray()) {
                int u = c - 'a';
                if (p.son[u] == null) {
                    p.son[u] = new Node();
                }

                p = p.son[u];
            }

            p.isEnd = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return dfs(root, word.toCharArray(), 0);
        }

        boolean dfs(Node p, char[] word, int i) {
            if (i == word.length) {
                return p.isEnd;
            }

            if (word[i] != '.') {
                int u = word[i] - 'a';
                if (p.son[u] == null)
                    return false;
                return dfs(p.son[u], word, i + 1);
            } else {
                // .
                for (int j = 0; j < 26; j++) {
                    if (p.son[j] != null && dfs(p.son[j], word, i + 1))
                        return true;
                }

                return false;
            }
        }
    }
}
