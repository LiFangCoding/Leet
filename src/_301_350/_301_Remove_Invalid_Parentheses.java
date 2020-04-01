package _301_350;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 */
public class _301_Remove_Invalid_Parentheses {
    List<String> ans;

    public List<String> removeInvalidParentheses(String s) {
        // 寻找不合法半边括号的个数
        int l = 0;
        int r = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }

        ans = new ArrayList<>();

        dfs(s, 0, l, r);
        return ans;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++count;
            } else if (c == ')') {
                --count;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }


    // l/r: number of left/right parentheses to remove.
    void dfs(String s, int st, int l, int r) {
        // Nothing to remove.
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }

        for (int i = st; i < s.length(); ++i) {
            // 去重
            if (i != st && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            String change = s.substring(0, i) + s.substring(i + 1);

            if (l > 0 && s.charAt(i) == '(') {
                dfs(change, i, l - 1, r);
            }

            if (r > 0 && s.charAt(i) == ')') {
                dfs(change, i, l, r - 1);
            }
        }
    }
}
