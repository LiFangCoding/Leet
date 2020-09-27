package leet._301_350;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 * <p>
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 *              1 + 99 = 100, 99 + 100 = 199
 *  
 * <p>
 * Constraints:
 * <p>
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * Follow up:
 * How would you handle overflow for very large input integers?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _306_Additive_number {
    class Sol_ac {
        public boolean isAdditiveNumber(String str) {
            char[] num = str.toCharArray();

            for (int i = 0; i < num.length; i++) {
                for (int j = i + 1; j + 1 < num.length; j++) {
                    // a + 1 -> b  first num
                    // b + 1 -> c  second num
                    int a = -1, b = i, c = j;
                    while (true) {
                        // 前导0
                        if (b - a > 1 && num[a + 1] == '0' || c - b > 1 && num[b + 1] == '0') break;
                        String x = str.substring(a + 1, b + 1);
                        String y = str.substring(b + 1, c + 1);
                        String z = add(x, y);
                        // 不匹配
                        if (c + 1 + z.length() > num.length || !str.substring(c + 1, c + 1 + z.length()).equals(z))
                            break;
                        a = b;
                        b = c;
                        c += z.length();
                        if (c + 1 == num.length) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        String add(String x, String y) {
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
            List<Integer> C = new ArrayList<>();

            for (int i = x.length() - 1; i >= 0; i--) {
                A.add(x.charAt(i) - '0');
            }
            for (int i = y.length() - 1; i >= 0; i--) {
                B.add(y.charAt(i) - '0');
            }

            for (int i = 0, t = 0; i < A.size() || i < B.size() || t != 0; i++) {
                if (i < A.size()) {
                    t += A.get(i);
                }

                if (i < B.size()) {
                    t += B.get(i);
                }

                C.add(t % 10);
                t = t / 10;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = C.size() - 1; i >= 0; i--) {
                sb.append((char) ('0' + C.get(i)));
            }
            return sb.toString();
        }
    }

    /**
     * https://www.jiuzhang.com/problem/additive-number/
     * https://www.acwing.com/solution/content/341/
     */
    class Solution {
        public boolean isAdditiveNumber(String num) {
            // Write your code here
            int n = num.length();
            for (int i = 1; i <= n / 2; ++i) {
                if (num.charAt(0) == '0' && i > 1)
                    return false;
                BigInteger x1 = new BigInteger(num.substring(0, i));
                for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                    if (num.charAt(i) == '0' && j > 1)
                        break;
                    BigInteger x2 = new BigInteger(num.substring(i, i + j));
                    if (isValid(x1, x2, j + i, num))
                        return true;
                }
            }
            return false;
        }

        private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
            if (start == num.length())
                return true;
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            String sum = x2.toString();
            return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
        }
    }
}
