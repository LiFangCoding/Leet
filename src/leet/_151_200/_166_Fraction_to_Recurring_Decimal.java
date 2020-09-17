package leet._151_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * <p>
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class _166_Fraction_to_Recurring_Decimal {
    public static void main(String[] args) {
        _166_Fraction_to_Recurring_Decimal test = new _166_Fraction_to_Recurring_Decimal();
        System.out.println(test.fractionToDecimal(2, 3));
    }

    public String fractionToDecimal(int n, int d) {
        if (n == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        // "+" or "-"

        if ((n < 0 && d > 0) || (n > 0 && d < 0)) {

            sb.append("-");
        }

        long divisor = Math.abs((long) n);
        long dividend = Math.abs((long) d);

        long remainder = divisor % dividend;
        sb.append(divisor / dividend);

        if (remainder == 0) {
            return sb.toString();
        }

        sb.append('.');
        /**
         * map from reminder -> 在字符串中的位置
         */
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / dividend);
            remainder %= dividend;
        }

        return sb.toString();
    }
}
