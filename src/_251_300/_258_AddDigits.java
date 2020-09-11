package _251_300;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example:
 * <p>
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class _258_AddDigits {
    class Sol_O_1 {
        public int addDigits(int x) {
            if (x == 0)
                return 0;
            if (x % 9 != 0)
                return x % 9;
            return 9;
        }
    }

    class Sol_mock {
        public int addDigits(int num) {
            while (num >= 10) {
                int tot = 0;
                for (; num > 0; num /= 10) {
                    tot += num % 10;
                }
                num = tot;
            }

            return num;
        }
    }
}
