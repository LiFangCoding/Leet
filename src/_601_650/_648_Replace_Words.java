package _601_650;

import java.util.ArrayList;
import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * <p>
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 * <p>
 * You need to output the sentence after the replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *  
 * <p>
 * Note:
 * <p>
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class _648_Replace_Words {
    public static void main(String[] args) {
        _648_Replace_Words test = new _648_Replace_Words();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");

        String sentence = "the cattle was rattled by the battery";
        System.out.println(test.replaceWords(dict, sentence));
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieTree trieTree = new TrieTree();

        for (String s : dict) {
            trieTree.insert(s);
        }

        String[] strs = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(trieTree.reachRoot(s));
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public class TrieTree {
        TrieNode root;

        public TrieTree() {
            root = new TrieNode();
        }

        private void insert(String s) {
            TrieNode cur = root;

            for (char c : s.toCharArray()) {
                if (cur.childrens[c - 'a'] == null) {
                    cur.childrens[c - 'a'] = new TrieNode();
                }
                cur = cur.childrens[c - 'a'];
            }

            cur.isEnd = true;
        }

        private String reachRoot(String s) {
            TrieNode cur = root;
            String path = "";

            for (char c : s.toCharArray()) {
                if (cur.childrens[c - 'a'] == null) {
                    return s;
                }
                cur = cur.childrens[c - 'a'];
                path += c;
                if (cur.isEnd) {
                    return path;
                }
            }

            return s;
        }
    }

    public class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        boolean isEnd = false;
    }
}
