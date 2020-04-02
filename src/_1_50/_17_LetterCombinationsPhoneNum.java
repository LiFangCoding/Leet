package _1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _17_LetterCombinationsPhoneNum {
    List<String> ans;
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        /**
         * when len = 0, res = [] not [""]
         */
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        dfs(digits, 0, "");
        return ans;
    }

    private void dfs(String digits, int s, String cur) {
        if (s == digits.length()) {
            ans.add(cur);
            return;
        }

        int i = digits.charAt(s) - '0';
        for (char c : map[i].toCharArray()) {
            dfs(digits, s + 1, cur + c);
        }
    }
}
