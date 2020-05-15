package _1_50;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Therefore INT_MIN (−231) is returned.
 */
public class _8_StringToInteger_atoi {
    /**
     * 您这种解法是把 Integer.MIN_VALUE ("-2147483648") 直接当作越界处理了吧，当然这里结果是对的，其实可以参考Jdk里面Integer类的处理方式，用负数做边界
     */
    class Sol_Int_Min_limit {
        public int myAtoi(String str) {
            if (str == null || str.length() <= 0) {
                return 0;
            }

            char[] A = str.toCharArray();
            //正负数的最大最小值
            int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
            int i = 0;
            //过滤空格
            while (i < str.length() && A[i] == ' ') {
                i++;
            }

            if (i == str.length()) {
                return 0;
            }

            boolean positive = true;

            //取正负号
            if (A[i] == '+') {
                i++;
            } else if (A[i] == '-') {
                positive = false;
                i++;
            }

            //用负数保存正负数的边界，这样不会溢出
            //正数 -2147483647
            //负数 -2147483648
            int limit = positive ? -MAX : MIN;
            //过滤0
//            while (i < str.length() && str.charAt(i) == '0')  i++;
            //取每一位,在非字符截止

            int ans = 0;
            while (i < str.length() && isValid(str.charAt(i))) {
                int digit = str.charAt(i++) - '0';
                if (ans < (limit + digit) / 10) {
                    return positive ? MAX : MIN;
                }
                //这里的res>=limit
                // 用减法. 减法即是负数
                ans = ans * 10 - digit; //
            }
            return positive ? -ans : ans;
        }

        public boolean isValid(char c) {
            return c >= '0' && c <= '9';
        }
    }

    class Sol_long {
        public int myAtoi(String str) {
            if (str == null) {
                return 0;
            }

            char[] A = str.toCharArray();
            int len = A.length;
            int i = 0;
            while (i < len && A[i] == ' ') {
                i++;
            }

            if (i >= len) {
                return 0;
            }

            boolean pos = true;

            if (A[i] == '+') {
                i++;
            } else if (A[i] == '-') {
                pos = false;
                i++;
            }

            long ans = 0L;

            //"9223372036854775808"
            // large than long.MAX_VALUE
            while (i < len && Character.isDigit(A[i])) {
                int digit = A[i] - '0';
                i++;

                // ans should be before two ifs. If it is after if, "2147483648". actual: -2147483648. exp : 2147483647
                ans = ans * 10 + digit;

                if (pos && ans > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                if (!pos && -1 * ans < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }

            if (!pos) {
                ans = -1 * ans;
            }


            return (int) ans;
        }
    }
}
