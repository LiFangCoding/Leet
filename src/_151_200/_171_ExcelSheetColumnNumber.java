package _151_200;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 */
public class _171_ExcelSheetColumnNumber {
    /**
     * Be careful with integer overflow if needed
     */
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();

        int len = chars.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            int num = chars[i] - 'A' + 1;
            res = res * 26 + num;
        }

        return res;
    }
}
