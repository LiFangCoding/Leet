package _201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * Example 1:
 * <p>
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 * <p>
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class _241_DifferentWaystoAddParentheses {
    /**
     * 2ms
     * T = Cn  卡特兰数
     * 采用递归的方式，每次通过某个运算符，将当前字符串分成左右两部分，递归子问题计算。
     * 然后根据左右两部分返回的结果，通过该运算符组合成新的结果。
     * 递归出口为当前字符串仅有一个数字。
     */
    List<String> expr;

    public List<Integer> diffWaysToCompute(String input) {
        expr = new ArrayList<>();
        char[] s = input.toCharArray();

        for (int i = 0; i < s.length; i++) {
            if (Character.isDigit(s[i])) {
                int j = i, x = 0;
                while (j < s.length && Character.isDigit(s[j])) x = x * 10 + (s[j++] - '0');
                i = j - 1;
                expr.add(String.valueOf(x));
            } else {
                expr.add("" + s[i]);
            }
        }
        return dfs(0, expr.size() - 1);
    }

    List<Integer> dfs(int l, int r) {
        List<Integer> res = new ArrayList<>();

        if (l == r) {
            res.add(Integer.parseInt(expr.get(l)));
            return res;
        }

        for (int i = l + 1; i < r; i += 2) {
            List<Integer> left = dfs(l, i - 1);
            List<Integer> right = dfs(i + 1, r);

            for (int x : left) {
                for (int y : right) {
                    int z = 0;
                    String ope = expr.get(i);
                    if (ope.equals("+")) z = x + y;
                    else if (ope.equals("-")) z = x - y;
                    else z = x * y;
                    res.add(z);
                }
            }
        }

        return res;
    }

}
