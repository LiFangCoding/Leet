package _301_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 * <p>
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _336_Palindrome_Pairs {
    /**
     * T = n * L ^ 2
     * TODO
     * https://www.acwing.com/solution/content/336/
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            String key = new StringBuilder(words[i]).reverse().toString();
            map.put(key, i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        if (map.containsKey("")) {
            for (int i = 0; i < n; i++) {
                if (words[i].equals("") && isPalindrome(words[i])) {
                    ans.get(map.get("")).add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);

                if (map.containsKey(left) && isPalindrome(right) && map.get(left) != i) {
                    ans.get(map.get(left)).add(i);
                }

                if (map.containsKey(right) && isPalindrome(right) && map.get(right) != i) {
                    ans.get(map.get(right)).add(i);
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;

    }
}
