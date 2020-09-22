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
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return res;
    }

    void dfs(int n, int lc, int rc, String s) {
        if (lc == n && rc == n) {
            res.add(s);
            return;
        }

        if (lc < n) {
            dfs(n, lc + 1, rc, s + "(");
        }
        if (rc < n && rc < lc) {
            dfs(n, lc, rc + 1, s + ")");
        }
    }
}
