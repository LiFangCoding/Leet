package leet;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * <p>
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 * <p>
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class _1249_Minumum_RemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char[] A = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] == '(') {
                // System.out.printf("here push for %d%n", i);
                stack.push(i);
            } else if (A[i] == ')') {
                // here is problem. A[stack.peek()] not stack.peek()
                if (!stack.isEmpty() && A[stack.peek()] == '(') {
                    // System.out.printf("here pop for %d%n", i);
                    stack.pop();
                } else {
                    // System.out.printf("here push for %d%n", i);
                    stack.push(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);

        // 每次删除会影响其后的索引，但是因为用的是栈结构，栈顶的都是最后那个需要删除的，并不会影响到前面的，所以这样写不会有问题
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}
