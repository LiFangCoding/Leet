package _1_50;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class _9_PalindromNumber {
    class Sol_all_reverse_int {
        public boolean isPalindrome1(int x) {
            if (x < 0) {
                return false;
            }
            int y = x;
            int res = 0;
            while (x != 0) {
                int digit = x % 10;
                if (res > (Integer.MAX_VALUE - digit) / 10) {
                    return false;
                }
                res = res * 10 + digit;
                x /= 10;
            }
            return res == y;
        }
    }

    /**
     * just compare first half and second half.
     * No need to consider the overflow.
     * Igore the number ending with 0. Then reverse will always has data.
     */
    public boolean isPalindrome2(int x) {
        /**
         * 0
         * 2
         * 23
         * 20
         * 23
         * 22
         * 302
         * 300
         * 323
         * 3012
         */
        if (x == 0) {
            return true;
        }

        // Be careful x = 0 will also need test.
      // -121, 121-. 10 01 false
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int secondhalf = 0;
        while (secondhalf <= x) {
            secondhalf = secondhalf * 10 + x % 10;
            if (secondhalf == x || secondhalf == x / 10) {
                return true;
            }
            x = x / 10;
        }
        return false;
    }
}
