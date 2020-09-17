package leet._101_150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class _140_word_break2 {
    /**
     * TLE
     * T = n ^ n
     * S = n ^ 3
     * 考虑最坏情况 ss = "aaaaaaa"，ss 的每一个前缀都在字典中，回溯树的大小会达到 n^n
     * <p>
     * 空间复杂度：O(n^3)，最坏情况下，回溯的深度可以达到 n 层，每层可能包含 n 个字符串，且每个字符串的长度都为 n 。
     * https://leetcode-cn.com/problems/word-break-ii/solution/dan-ci-chai-fen-ii-by-leetcode/
     */
    class Sol_Brute_Force {
        public List<String> wordBreak(String s, Set<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            return word_Break(s, set, 0);
        }

        public List<String> word_Break(String s, Set<String> wordDict, int start) {
            LinkedList<String> res = new LinkedList<>();
            if (start == s.length()) {
                res.add("");
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start, end))) {
                    List<String> list = word_Break(s, wordDict, end);
                    for (String l : list) {
                        res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                    }
                }
            }
            return res;
        }
    }

    /**
     * T = 14ms
     * T = n ^ 3? yxc说是指数级复杂度
     * 回溯树的大小最多 n^2. 创建列表需要 nn 的时间
     * If we use void, we have to iterate all the backtrack tree. Cannot use memo.
     */
    class Sol_Recursio_Memo {
        public List<String> wordBreak(String s, List<String> words) {
            Set<String> set = new HashSet<>(words);
            return word_Break(s, set, 0);
        }

        HashMap<Integer, List<String>> map = new HashMap<>();

        public List<String> word_Break(String s, Set<String> wordDict, int start) {
            if (map.containsKey(start)) {
                return map.get(start);
            }

            LinkedList<String> res = new LinkedList<>();
            if (start == s.length()) {
                res.add("");
            }

            for (int i = start + 1; i <= s.length(); i++) {
                if (wordDict.contains(s.substring(start, i))) {
                    List<String> list = word_Break(s, wordDict, i);
                    for (String l : list) {
                        res.add(s.substring(start, i) + (l.equals("") ? "" : " ") + l);
                    }
                }
            }

            map.put(start, res);
            return res;
        }
    }
}
