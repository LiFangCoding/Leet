package leet._51_100;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class _91_Decode_Ways {
    class Sol_dp {
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int len = s.length();
            /**
             * f[i] means the first ith character, the number of ways to do. Index is i - 1
             * f[i] = f[i - 1] + f[i -2] (if two character correct)
             */
            int[] f = new int[len + 1];
            f[0] = 1;

            for (int i = 1; i <= len; i++) {
                if (i == 1) {
                    f[i] += s.charAt(i - 1) == '0' ? 0 : 1;
                } else {
                    // else is importatn. Else the i= 0,1 will come here and exception
                    if (f[i - 1] == 0 && f[i - 2] == 0) {
                        return 0;
                    }

                    f[i] += s.charAt(i - 1) == '0' ? 0 : f[i - 1];
                    int val = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                    //                    int val = Integer.parseInt(s.substring(i - 2, i));
                    if (val >= 10 && val <= 26) {
                        f[i] += f[i - 2];
                    }
                }
            }

            return f[len];
        }
    }

    class Sol_recursion {
        /**
         * Recursion can be slow
         * f[4]
         * f[3] f[2]
         * f[2]f[1]  f[1]f[0]
         */
        public int numDecodings_recursion(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            return helper(s, 0);
        }

        public int helper(String s, int start) {
            if (start == s.length()) {
                return 1;
            }

            int res = 0;
            int num = s.charAt(start) - '0';
            if (num >= 1 && num <= 9) {
                res += helper(s, start + 1);
            }

            if (start + 1 < s.length()) {
                num = (s.charAt(start) - '0') * 10 + (s.charAt(start + 1) - '0');
                if (num >= 10 && num <= 26) {
                    res += helper(s, start + 2);
                }
            }

            return res;
        }
    }
}
