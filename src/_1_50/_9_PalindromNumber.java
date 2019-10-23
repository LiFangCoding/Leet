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
    public boolean isPalindrome1(int num) {
        if (num < 0) {
            return false;
        }

        int origin = num;
        int rev = 0;

        while (num != 0) {
            int digit = num % 10;
            if (rev > (Integer.MAX_VALUE - digit) / 10) {
                return false;
            }
            rev = rev * 10 + digit;
            num /= 10;
        }

        return rev == origin;
    }

    /**
     * just compare first half and second half.
     * No need to consider the overflow.
     * Igore the number ending with 0. Then reverse will always has data.
     */
    public boolean isPalindrome2(int num) {
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
        if (num == 0) {
            return true;
        }

        // Be careful num = 0 will also need test.
        if (num < 0 || num % 10 == 0) {
            return false;
        }

        int secondhalf = 0;
        while (secondhalf <= num) {
            secondhalf = secondhalf * 10 + num % 10;
            if (secondhalf == num || secondhalf == num / 10) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }
}
