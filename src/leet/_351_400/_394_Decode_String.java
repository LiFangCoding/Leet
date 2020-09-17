package leet._351_400;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _394_Decode_String {
    /**
     * 0ms
     * T = len(string)×k^n
     * S = N + ans space
     * 用递归的思想来解决这个问题， 当遇到一个括号时，就将括号内的字符串截取出来作为一个新的子问题递归求解，比如对于s = "3[a2[c]]"，我们可以将a2[c]]作为一个新问题来求解，并将该子问题求解的结果加到上一层的答案中去。
     * <p>
     * 时间复杂度
     * 最坏情况下，假如字符串形如k[k[k[k[k[string]]]]]这种形式，不妨设嵌套层数为n，那么最后形成的字符串长度为 len(string)×k^n, 则时间复杂度至少与字符串的长度成正比。
     * 链接：https://www.acwing.com/solution/LeetCode/content/5575/
     */
    class Sol_recursion {
        public String decodeString(String s) {
            StringBuilder sb = new StringBuilder();
            char[] A = s.toCharArray();
            int len = s.length();

            for (int i = 0; i < len; ) {
                if (Character.isDigit(A[i])) {
                    int j = i;
                    int t = 0;
                    while (Character.isDigit(A[j])) {
                        t = t * 10 + A[j] - '0';
                        j++;
                    }

                    i = ++j;
                    int cnt = 1;
                    while (cnt > 0) {
                        if (A[j] == '[') {
                            cnt++;
                        } else if (A[j] == ']') {
                            cnt--;
                        }
                        j++;
                    }

                    String res = decodeString(s.substring(i, j - 1));
                    // System.out.printf("the decode string from %d to %d is %s, cnt is %d%n", i, j - 1, s.substring(i, j - 1), t);

                    while (t-- > 0) {
                        sb.append(res);
                    }
                    i = j;
                } else {
                    sb.append(A[i]);
                    i++;
                }
            }

            return sb.toString();
        }
    }

    /**
     * 如果递归层数太多则上面的算法有可能会造成栈溢出，我们可以用栈来模拟上述的递归过程，
     * 每当遇到一个括号序列时，说明我们要递归进入下一层，
     * 那么我们就把该序列重复的次数num和在该序列前已经计算好的答案字cur分别压入栈中，
     * 当把这个括号序列处理完后，我们从两个栈的栈顶分别取出来之前的num和cur来计算出新的答案cur。
     */
    class Sol_Stack {
        public String decodeString(String s) {
            Stack<Integer> nums = new Stack<>();
            Stack<String> strs = new Stack<>();

            String cur = "";
            int num = 0;
            char[] A = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                if (A[i] == '[') {
                    nums.push(num);
                    strs.push(cur);
                    num = 0;
                    cur = "";
                } else if (A[i] == ']') {
                    int t = nums.pop();

                    String prevStr = strs.pop();
                    StringBuilder sb = new StringBuilder(prevStr);
                    while (t-- > 0) {
                        sb.append(cur);
                    }
                    cur = sb.toString();
                } else if (Character.isDigit(A[i])) {
                    num = num * 10 + A[i] - '0';
                } else {
                    cur += A[i];
                }
            }

            return cur;
        }
    }
}
