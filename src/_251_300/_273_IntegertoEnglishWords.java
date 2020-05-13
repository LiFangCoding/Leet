package _251_300;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class _273_IntegertoEnglishWords {

    String[] below_20 = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] below_100 = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    class MySol {
        String[] below_20 = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] below_100 = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        int hundred = 100;
        int twenty = 20;


        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }

            String s = convert(num);
            return s.substring(0, s.length() - 1);
        }

        public String convert(int n) {
            if (n >= billion) {
                return convert(n / billion) + "Billion " + convert(n % billion);
            } else if (n >= million) {
                return convert(n / million) + "Million " + convert(n % million);
            } else if (n >= thousand) {
                // 1000 is not " One Thousand Zero"
                return convert(n / thousand) + "Thousand " + convert(n % thousand);
            } else if (n >= hundred) {
                return convert(n / hundred) + "Hundred " + convert(n % hundred);
            } else if (n >= twenty) {
                return below_100[n / 10 - 2] + " " + convert(n % 10);
            } else if (n >= 1) {
                return below_20[n - 1] + " ";
            } else {
                // 20 actual: "Twenty "  expected："Twenty". If " "
                return "";
            }
        }
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        } else {
            return int_string(num).substring(1);
        }
    }

    String int_string(int n) {
        if (n >= 1000000000) {
            return int_string(n / 1000000000) + " Billion" + int_string(n % 1000000000);
        } else if (n >= 1000000) {
            return int_string(n / 1000000) + " Million" + int_string(n % 1000000);
        } else if (n >= 1000) {
            return int_string(n / 1000) + " Thousand" + int_string(n % 1000);
        } else if (n >= 100) {
            return int_string(n / 100) + " Hundred" + int_string(n % 100);
        } else if (n >= 20) {
            return " " + below_100[n / 10 - 2] + int_string(n % 10);
        } else if (n >= 1) {
            return " " + below_20[n - 1];
        } else {
            return "";
        }
    }
}
