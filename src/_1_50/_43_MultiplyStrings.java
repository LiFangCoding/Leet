package _1_50;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class _43_MultiplyStrings {
    public static void main(String[] args) {
        _43_MultiplyStrings test = new _43_MultiplyStrings();

        System.out.println(test.multiply("12", "1"));

        String expected = "419553";
        System.out.println(test.multiply("123", "3411"));
    }

    /**
     * p 0 1 2
     * 1 0 2
     * 3 1 1
     * <p>
     * 1  0  2
     * 1 0  2
     * 3 0 6
     */
    //TODO
    public String multiply(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int m = chars1.length;
        int n = chars2.length;

        int[] digits = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int pos1 = i + j + 1;
                int pos2 = pos1 - 1;

                int d1 = chars1[i] - '0';
                int d2 = chars2[j] - '0';

                digits[pos1] += d1 * d2;
                digits[pos2] += digits[pos1] / 10;
                digits[pos1] = digits[pos1] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (i < digits.length) {
            if (digits[i] == 0) {
                i++;
            } else {
                break;
            }
        }

        if (i == digits.length) {
            return "0";
        } else {
            for (; i < digits.length; i++) {
                sb.append(digits[i]);
            }

            return sb.toString();
        }
    }
}
