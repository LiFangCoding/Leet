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
    /**
     * T = m + n
     * S = m + n
     */
    class Sol_reverse {
        public String multiply(String s1, String s2) {
            String str;
            char[] A1 = s1.toCharArray();
            char[] A2 = s2.toCharArray();

            int len1 = A1.length, len2 = A2.length;

            int[] a = new int[len1], b = new int[len2], c = new int[len1 + len2];

            for (int i = 0; i < len1; i++) {
                a[len1 - i - 1] = A1[i] - '0';
            }

            for (int i = 0; i < len2; i++) {
                b[len2 - i - 1] = A2[i] - '0';
            }

            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    c[i + j] += a[i] * b[j];
                    c[i + j + 1] += c[i + j] / 10;
                    c[i + j] %= 10;
                }
            }

            int l = c.length - 1;
            // l >= 0 should be first. because avoid index outbound
            while (l >= 0 && c[l] == 0) {
                l--;
            }

            if (l < 0) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for (int i = l; i >= 0; i--) {
                sb.append(c[i]);
            }

            return sb.toString();
        }
    }

    /**
     * 4ms
     * T = m + n
     * S = m + n
     */
    class Sol_no_need_reverse {
        /**
         * p 0 1 2
         * 1 0 2
         * 3 1 1
         * <p>
         * 1  0  2
         * 1 0  2
         * 3 0 6
         */
        public String multiply(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return "";
            }

            char[] A1 = s1.toCharArray();
            char[] A2 = s2.toCharArray();

            int m = A1.length;
            int n = A2.length;

            // have int[] array to store the elements is important
            // 结果最多为 m + n 位数
            int[] c = new int[m + n];

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int mul = (A1[i] - '0') * (A2[j] - '0');
                    int p1 = i + j;
                    int p2 = p1 + 1;

                    int sum = mul + c[p2];
                    c[p2] = sum % 10;
                    c[p1] += sum / 10;
                }
            }

            int i = 0;
            while (i < c.length && c[i] == 0) {
                i++;
            }

            if (i == c.length) {
                return "0";
            }

            StringBuilder sb = new StringBuilder();
            for (; i < c.length; i++) {
                sb.append(c[i]);
            }

            return sb.toString();
        }
    }
}
