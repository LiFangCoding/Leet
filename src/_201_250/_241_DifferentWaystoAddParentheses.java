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
  //TODO: more practice

  /**
   * 2ms
   * T = Cn  卡特兰数
   * 采用递归的方式，每次通过某个运算符，将当前字符串分成左右两部分，递归子问题计算。
   * 然后根据左右两部分返回的结果，通过该运算符组合成新的结果。
   * 递归出口为当前字符串仅有一个数字。
   */
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
        String part1 = input.substring(0, i);
        String part2 = input.substring(i + 1);
        List<Integer> part1Ans = diffWaysToCompute(part1);
        List<Integer> part2Ans = diffWaysToCompute(part2);

        for (Integer p1 : part1Ans) {
          for (Integer p2 : part2Ans) {
            int c = 0;
            switch (input.charAt(i)) {
            case '+':
              c = p1 + p2;
              break;
            case '-':
              c = p1 - p2;
              break;
            case '*':
              c = p1 * p2;
              break;
            }
            ans.add(c);
          }
        }
      }
    }

    if (ans.size() == 0) {
      ans.add(Integer.valueOf(input));
    }

    return ans;
  }
}
