package _201_250;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class _202_HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (true) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                n /= 10;
                sum += digit * digit;
            }
            if (sum == 1) {
                return true;
            }

            if (set.contains(sum)) {
                return false;
            }

            set.add(sum);
            n = sum;
        }

        /**
         * No need to add thing after while(true).
         * it will never reach to that end
         */
    }

    /**
     * Use the slow and fast pointer
     */
    public boolean isHappy_twopointers(int n) {
        int slow = n;
        int fast = squareSum(n);

        while (true) {
            if (slow == fast) {
                return slow == 1;
            }

            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
