package leet._301_350;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    //TODO: more

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
        List<String> ans = new ArrayList<>();

        public List<String> removeInvalidParentheses(String str) {
            char[] s = str.toCharArray();

            // l is current l paren - r paren, r is right paren to delete
            int l = 0, r = 0;
            for (char x : s) {
                if (x == '(') l++;
                else if (x == ')') {
                    // left paren == right paren
                    if (l == 0) r++;
                    else l--;
                }
            }

            // l is left to delete, r is right to delete
            // 0 is char idx. "" current str, 0 is left -right paren, l is how mnay left to delte. r is how mnay right to delete.
            dfs(s, 0, "", 0, l, r);
            return ans;
        }


        void dfs(char[] s, int u, String path, int cnt, int l, int r) {
            if (u == s.length) {
                // if left paren == right paren
                if (cnt == 0) {
                    ans.add(path);
                }
                return;
            }

            // not '()', add to path and continue
            if (s[u] != '(' && s[u] != ')') {
                dfs(s, u + 1, path + s[u], cnt, l, r);
            } else if (s[u] == '(') {
                int k = u;
                // see how many '('
                while (k < s.length && s[k] == '(') k++;
                // delete all left paren
                l -= k - u;
                for (int i = k - u; i >= 0; i--) {
                    if (l >= 0) {
                        dfs(s, k, path, cnt, l, r);
                    }
                    path += '(';
                    cnt++;
                    l++;
                }
            } else if (s[u] == ')') {
                int k = u;
                while (k < s.length && s[k] == ')') {
                    k++;
                }
                r -= k - u;
                for (int i = k - u; i >= 0; i--) {
                    if (cnt >= 0 && r >= 0) {
                        dfs(s, k, path, cnt, l, r);
                    }
                    path += ')';
                    cnt--;
                    r++;
                }
            }
        }
    }

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
}
