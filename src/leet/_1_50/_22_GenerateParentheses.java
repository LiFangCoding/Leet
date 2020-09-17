package leet._1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class _22_GenerateParentheses {
    //TODO
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        dfs(n, n, "");
        return ans;
    }

    private void dfs(int l, int r, String cur) {
        // base case
        if (l == 0 && r == 0) {
            ans.add(cur);
            return;
        }

        if (l == r) {
            dfs(l - 1, r, cur + "(");
        } else if (l < r) {
            if (l > 0) {
                dfs(l - 1, r, cur + "(");
            }

            if (r > 0) {
                dfs(l, r - 1, cur + ")");
            }
        }
    }
}
