import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class _22_GenerateParentheses {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }

        getParen(n, n, "");
        return res;
    }

    /**
     * leftn
     * @param leftn  num of paren needed to place
     * @param rightn
     * @param path
     */
    private void getParen(int leftn, int rightn, String path) {
        // base case
        if (leftn == 0 && rightn == 0) {
            res.add(path);
        } else {
            if (leftn > 0) {
                getParen(leftn - 1, rightn, path + "(");
            }

            if (leftn < rightn) {
                getParen(leftn, rightn - 1, path + ")");
            }
        }
    }
}
