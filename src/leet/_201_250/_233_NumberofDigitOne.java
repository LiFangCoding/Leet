package leet._201_250;

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * <p>
 * Example:
 * <p>
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class _233_NumberofDigitOne {
    //TODO:

    /**
     * https://www.acwing.com/solution/content/280/
     * https://www.acwing.com/solution/content/280/
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        if (n < 10)
            return 1;
        String s = String.valueOf(n);
        int last = Integer.parseInt(s.substring(1));
        int power = (int) Math.pow(10, s.length() - 1);
        int high = s.charAt(0) - '0';//当前字符的ASCII码减去‘0’的ASCII码
        if (high == 1) {
            return countDigitOne(last) + countDigitOne(power - 1) + last + 1;
        } else {
            return power + high * countDigitOne(power - 1) + countDigitOne(last);
        }
    }
}
