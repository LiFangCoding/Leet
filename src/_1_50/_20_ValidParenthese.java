package _1_50;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class _20_ValidParenthese {
    /**
     * 16'45
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // c = left char
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // c = right char
                if (stack.isEmpty()) {
                    return false;
                }

                char previous = stack.pop();
                if (c == ')' && previous != '(') {
                    return false;
                } else if (c == '}' && previous != '{') {
                    return false;
                } else if (c == ']' && previous != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
