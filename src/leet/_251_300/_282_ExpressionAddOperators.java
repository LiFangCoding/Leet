package leet._251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * <p>
 * Example 1:
 * <p>
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 * <p>
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * Example 3:
 * <p>
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 * <p>
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * Example 5:
 * <p>
 * Input: num = "3456237490", target = 9191
 * Output: []
 */
public class _282_ExpressionAddOperators {
    //TODO
    /**
     * T = 4 ^ n.  +,-,*, ''四种可能
     * https://www.jiuzhang.com/solution/expression-add-operators/#tag-highlight
     * https://www.acwing.com/solution/content/4587/
     */

    List<String> ans;

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        dfs(num, 0, 0, 1, "", target);
        return ans;
    }

    void dfs(String num, int u, long a, long b, String path, int target) {
        if (u == num.length()) {
            if (a == target) ans.add(path.substring(0, path.length() - 1));
        } else {
            long cur = 0;
            for (int i = u; i < num.length(); i++) {
                cur = cur * 10 + num.charAt(i) - '0';
                String cpath = num.substring(u, i + 1);

                //+
                dfs(num, i + 1, a + b * cur, 1, path + cpath + '+', target);

                if (i + 1 < num.length()) {
                    // -
                    dfs(num, i + 1, a + b * cur, -1, path + cpath + '-', target);
                    // *
                    dfs(num, i + 1, a, b * cur, path + cpath + '*', target);
                }
                if (num.charAt(u) == '0') break;
            }
        }
    }
}
