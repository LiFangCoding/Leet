package _1_50;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class _32_LongestValidParentheses {
    //TODO
    /**
     * 1ms
     * T = n
     * S = 1
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     */
    class Sol_DP {
        public int longestValidParentheses(String s) {
            char[] A = s.toCharArray();
            int len = A.length;

            // 我们定义一个 dp 数组，其中第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度。
            int[] f = new int[len];

            int ans = 0;
            for (int i = 1; i < len; i++) {
                if (A[i] == ')') {
                    if (A[i - 1] == '(') {
                        f[i] = 2;
                        if (i - 2 >= 0) {
                            f[i] = f[i] + f[i - 2];
                        }
                    } else if (f[i - 1] > 0) {
                        if ((i - f[i - 1] - 1) >= 0 && A[i - f[i - 1] - 1] == '(') {
                            f[i] = f[i - 1] + 2;
                            if ((i - f[i - 1] - 2) >= 0) {
                                f[i] = f[i] + f[i - f[i - 1] - 2];
                            }
                        }
                    }
                }

                ans = Math.max(ans, f[i]);
            }

            return ans;
        }

        /**
         * 3 ms
         * T = n
         * S = n for stack space
         * 使用栈来模拟操作。栈顶保存当前扫描的时候，当前合法序列前的一个位置位置下标是多少。初始时栈中元素为-1。然后遍历整个字符串
         * <p>
         * 如果s[i] =='('，那么把i进栈。
         * 如果s[i] == ')',那么弹出栈顶元素 （代表栈顶的左括号匹配到了右括号）
         * 如果此时栈为空，将i进栈。说明之前没有与之匹配的左括号，那么就将当前的位置入栈。
         * 否则，i - st.top()就是当前右括号对应的合法括号序列长度。
         */
        class Sol_Stack {
            public int longestValidParentheses(String s) {
                char[] A = s.toCharArray();
                int len = A.length;

                // stack for the index i
                Stack<Integer> stack = new Stack<>();
                // 赞，先push进去一个 - 1，防止栈 pop 抛出异常
                // https://www.acwing.com/solution/LeetCode/content/4177/
                stack.push(-1);
                int ans = 0;

                for (int i = 0; i < len; i++) {
                    if (A[i] == '(') {
                        stack.push(i);
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(i);
                        } else {
                            ans = Math.max(ans, i - stack.peek());
                        }
                    }
                }

                return ans;
            }
        }

        /**
         * 421ms
         * T = n ^ 2
         * S = 1
         */
        class Sol_Brute_n2 {
            public int longestValidParentheses(String s) {
                if (s == null || s.length() == 0) {
                    return 0;
                }

                char[] A = s.toCharArray();
                int len = A.length;
                int ans = 0;

                for (int i = 0; i < len; i++) {
                    if (A[i] == '(') {
                        // if balance ==0, get a valid one. If < 0, return invalid
                        int cur = 0, bal = 1;
                        for (int j = i + 1; j < len; j++) {
                            if (A[j] == '(') {
                                bal++;
                            } else {
                                bal--;
                            }

                            if (bal == 0) {
                                cur = j - i + 1;
                            }
                            if (bal < 0) {
                                break;
                            }
                        }
                        ans = Math.max(ans, cur);
                    }
                }

                return ans;
            }
        }

        /**
         * 超出时间限制
         * T = n ^ 3
         * S = n
         */
        class Sol_Brute {
            public int longestValidParentheses(String s) {
                if (s == null || s.length() == 0) {
                    return 0;
                }

                char[] A = s.toCharArray();
                int len = A.length;

                for (int size = len; size >= 0; size--) {
                    for (int i = 0; i + size <= len; i++) {
                        String subS = s.substring(i, i + size);
                        if (valid(subS)) {
                            return size;
                        }
                    }
                }

                return 0;
            }

            private boolean valid(String s) {
                Stack<Character> stack = new Stack<>();
                for (char c : s.toCharArray()) {
                    if (c == '(') {
                        stack.push(c);
                    } else {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        stack.pop();
                    }
                }

                return stack.isEmpty();
            }
        }
    }
}
