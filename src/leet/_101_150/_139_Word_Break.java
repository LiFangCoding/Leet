package leet._101_150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class _139_Word_Break {
    public static void main(String[] args) {
        _139_Word_Break test = new _139_Word_Break();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        System.out.println(test.wordBreak_brute(s, wordDict));
        System.out.println(test.wordBreak(s, wordDict));
    }

    /**
     * beat 90.50%
     */
    public boolean wordBreak_another(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; ++i) {
            for (String w : wordDict) {
                int len = w.length();
                if (i >= len && s.substring(i - len, i).equals(w)) {
                    dp[i] = dp[i] || dp[i - len];
                }

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[n];
    }

    /**
     * O(n^2)
     * use dp.
     * Need a base case. This is why use dp[0] means first ith characters not the ith index.
     * <p>
     * <p>
     * dp[i] means the first ith can be wordbreak.
     * The ans is dp[len]
     * <p>
     * dp[i]= (dp [j] + cantains(j ~ i - 1) for all j between 0 and i - 1
     * 0 - (i - 1)
     * <p>
     * beat 96.73%
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = getMaxLength(set);

        //dp[i] 表示第 i 个字符前，所有的字符是否可以按字典拆分成单词
        // 其中第 i - 1 个字符是上一个词的结尾字母，第 i 个字符是一个新词的开头字母
        // 初始值 dp[0] = true ，表示第 0 个字符是一个新词的开头字母
        // 所求的答案为 dp[s.size()] ，表示这个字符串是否可以拆分成字典中
        for (int i = 1; i <= len; i++) {
            for (int j = Math.max(0, (i - maxLen)); j <= i - 1; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }

    private int getMaxLength(Set<String> dict) {
        int max = 0;
        for (String s : dict) {
            max = Math.max(max, s.length());
        }
        return max;
    }

    /**
     * Will have Time Limit Exceeded
     * O(n^n) ?
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_brute(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();

        Set<String> set = new HashSet<>(wordDict);
        return helper(chars, 0, set);
    }

    private boolean helper(char[] chars, int start, Set<String> set) {
        if (start == chars.length) {
            return true;
        }

        for (int i = start; i < chars.length; i++) {
            String s = new String(chars, start, i - start + 1);
            if (set.contains(s) && helper(chars, i + 1, set)) {
                return true;
            }
        }

        return false;
    }
}
