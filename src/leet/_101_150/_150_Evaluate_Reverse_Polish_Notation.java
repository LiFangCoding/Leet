package leet._101_150;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class _150_Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        _150_Evaluate_Reverse_Polish_Notation test = new _150_Evaluate_Reverse_Polish_Notation();
        String[] A = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(test.evalRPN(A));
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";
        for (String s : tokens) {
            /**
             * !!! string.equals(). Not s1 == s2. !!!
             */
            if (operators.contains(s)) {
                int second = stack.pop();
                int first = stack.pop();

                if (s.equals("*")) {
                    stack.push(second * first);
                } else if (s.equals("/")) {
                    stack.push(first / second);
                } else if (s.equals("+")) {
                    stack.push(first + second);
                } else if (s.equals("-")) {
                    stack.push(first - second);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
