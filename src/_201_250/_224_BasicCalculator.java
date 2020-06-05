package _201_250;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * Example 1:
 * <p>
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * <p>
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class _224_BasicCalculator {
  /**
   * 28ms
   * T = n
   * https://www.acwing.com/solution/content/321/
   * https://www.acwing.com/solution/content/6431/
   */
  class Sol_two_stacks {
    Stack<Character> op = new Stack<>();
    Stack<Integer> num = new Stack<>();

    private void calc() {
      int y = num.peek();
      num.pop();
      int x = num.peek();
      num.pop();
      if (op.peek() == '+')
        num.push(x + y);
      else
        num.push(x - y);
      op.pop();
    }

    public int calculate(String s) {
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == ' ')
          continue;
        if (c == '+' || c == '-' || c == '(')
          op.push(c);
        else if (c == ')') {
          op.pop();
          if (!op.isEmpty() && op.peek() != '(') {
            calc();
          }
        } else {
          int j = i;
          int val = 0;
          while (j < s.length() && Character.isDigit(s.charAt(j))) {
            val = val * 10 + s.charAt(j) - '0';
            j++;
          }
          num.push(val);
          i = j - 1;
          if (!op.isEmpty() && op.peek() != '(') {
            calc();
          }
        }
      }
      return num.peek();
    }
  }

  class Sol_num_add_num {
    /**
     * 9 ms
     * https://www.jiuzhang.com/solution/basic-calculator/
     * https://www.acwing.com/solution/content/6431/
     * T = n
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
      Stack<Integer> stack = new Stack<Integer>();
      int result = 0;
      int number = 0;
      int sign = 1;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (Character.isDigit(c)) {
          number = 10 * number + (int) (c - '0');
        } else if (c == '+') {
          result += sign * number;
          number = 0;
          sign = 1;
        } else if (c == '-') {
          result += sign * number;
          number = 0;
          sign = -1;
        } else if (c == '(') {
          //we push the result first, then sign;
          stack.push(result);
          stack.push(sign);
          //reset the sign and result for the value in the parenthesis
          sign = 1;
          result = 0;
        } else if (c == ')') {
          result += sign * number;
          number = 0;
          result *= stack.pop();    //stack.pop() is the sign before the parenthesis
          result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

        }
      }
      if (number != 0) {
        result += sign * number;
      }
      return result;
    }
  }
}
