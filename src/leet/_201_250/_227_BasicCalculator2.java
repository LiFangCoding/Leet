package leet._201_250;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class _227_BasicCalculator2 {
    class Sol_acwing_muban {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        public int calculate(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('+', 1);
            map.put('-', 1);
            map.put('*', 2);
            map.put('/', 2);

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;

                if (Character.isDigit(c)) {
                    int num = 0, j = i;

                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        num = num * 10 + (s.charAt(j) - '0');
                        j++;
                    }
                    nums.push(num);
                    i = j - 1;
                }
                // c is operator
                else {
                    while (!ops.isEmpty() && map.get(ops.peek()) >= map.get(c)) eval();
                    ops.push(c);
                }
            }

            while (!ops.isEmpty()) eval();
            return nums.peek();
        }

        // calculate one time
        void eval() {
            int b = nums.pop();
            int a = nums.pop();
            char op = ops.pop();

            int res;
            if (op == '+') res = a + b;
            else if (op == '-') res = a - b;
            else if (op == '*') res = a * b;
            else res = a / b;
            nums.push(res);
        }
    }

    class Sol_other_leet {
        /**
         * need time. Haojun
         *
         * @param s
         * @return
         */
        public int calculate(String s) {
            // Write your code here
            int len;
            if (s == null || (len = s.length()) == 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<Integer>();
            int num = 0;
            char sign = '+';

            for (int i = 0; i < len; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }

                if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                    if (sign == '-') {
                        stack.push(-num);
                    }
                    if (sign == '+') {
                        stack.push(num);
                    }
                    if (sign == '*') {
                        stack.push(stack.pop() * num);
                    }

                    if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    sign = s.charAt(i);
                    num = 0;
                }
            }

            int re = 0;
            for (int i : stack) {
                re += i;
            }
            return re;
        }
    }
}
