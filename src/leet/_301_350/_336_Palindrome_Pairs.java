package leet._301_350;

import java.util.ArrayList;
import java.util.Arrays;
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
     * TODO: more practice
     * https://www.acwing.com/solution/content/336/
     * https://leetcode-cn.com/problems/palindrome-pairs/solution/tu-jie-zhua-zhu-hui-wen-chuan-te-dian-dui-dan-ci-j/
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
        //        if (map.containsKey("")) {
        //            for (int i = 0; i < n; i++) {
        //                if (words[i].equals("") && isPalindrome(words[i])) {
        //                    ans.add(Arrays.asList(i,map.get("")));
        //                }
        //            }
        //        }

        for (int i = 0; i < n; i++) {
            if (isPalindrome(words[i]) && map.containsKey("") && !words[i].equals("")) {
                ans.add(Arrays.asList(map.get(""), i)); // curWord !== '' 是为了避免 "" 和 "" 搭配
            }
            for (int j = 0; j < words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);

                if (isPalindrome(left) && map.containsKey(right) && map.get(right) != i) {
                    ans.add(Arrays.asList(map.get(right), i));
                }

                if (isPalindrome(right) && map.containsKey(left) && map.get(left) != i) {
                    ans.add(Arrays.asList(i, map.get(left)));
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
