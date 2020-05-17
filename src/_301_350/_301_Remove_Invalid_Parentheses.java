package _301_350;

import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 */
public class _301_Remove_Invalid_Parentheses {
    class Sol_BFS {
        public List<String> removeInvalidParentheses(String s) {
            Set<String> set = new HashSet<>();
            List<String> ans = new ArrayList<>();
            // use set to remove duplicates
            set.add(s);

            while (true) {
                for (String str : set) {
                    if (isValid(str)) {
                        ans.add(str);
                    }
                }

                if (ans.size() > 0) {
                    return ans;
                }

                Set<String> nextSet = new HashSet<>();
                for (String str : set) {
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                            nextSet.add(str.substring(0, i) + str.substring(i + 1));
                        }
                    }
                }
                set = nextSet;
            }
        }

        public boolean isValid(String s) {
            char[] ss = s.toCharArray();
            int count = 0;
            for (char c : ss) {
                if (c == '(') {
                    count++;
                } else if (c == ')') {
                    count--;
                }

                if (count < 0) {
                    return false;
                }
            }
            return count == 0;
        }
    }

    /**
     * 此题与之前的生成括号方式互为相反的过程，生成时我们需要记录已加入的左边和右边括号个数，删除时我们也需要。
     * 在此题中，解题步骤如下：
     * <p>
     * 我们需要先找出不合法的左括号个数和右括号个数
     * 利用dfs不断删除"（"或者"）"，直到不合法个数为0
     * 检验删除后的括号串是否合法。
     * <p>
     * 作者：shaft
     * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses/solution/shen-du-you-xian-sou-suo-jie-ti-by-shaft/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Sol_DFS {
        List<String> ans;

        public List<String> removeInvalidParentheses(String s) {
            // 寻找不合法半边括号的个数
            int l = 0;
            int r = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    l++;
                } else if (c == ')') {
                    if (l > 0) {
                        l--;
                    } else {
                        r++;
                    }
                }
            }

            ans = new ArrayList<>();

            dfs(s, 0, l, r);
            return ans;
        }

        private boolean isValid(String s) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    ++cnt;
                } else if (c == ')') {
                    --cnt;
                    if (cnt < 0) {
                        return false;
                    }
                }
            }
            return cnt == 0;
        }

        private boolean isValid_stack(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    stack.pop();
                }
            }

            return stack.isEmpty();
        }


        // l/r: number of left/right parentheses to remove.
        void dfs(String s, int st, int l, int r) {
            // Nothing to remove.
            if (l == 0 && r == 0) {
                if (isValid(s)) {
                    ans.add(s);
                }
                return;
            }

            for (int i = st; i < s.length(); ++i) {
                // 去重
                if (i > st && s.charAt(i) == s.charAt(i - 1)) {
                    continue;
                }

                String change = s.substring(0, i) + s.substring(i + 1);

                if (l > 0 && s.charAt(i) == '(') {
                    dfs(change, i, l - 1, r);
                }

                if (r > 0 && s.charAt(i) == ')') {
                    dfs(change, i, l, r - 1);
                }
            }
        }
    }
}
