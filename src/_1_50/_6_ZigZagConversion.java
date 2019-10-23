package _1_50;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class _6_ZigZagConversion {
    /**
     * O(n)
     * @param s
     * @return
     */
    public static String convert(String s, int nRows) {
        // O(n)
        if (s == null || s.length() == 0 || nRows <= 0) {
            return "";
        }

        if (nRows == 1) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int size = 2 * nRows - 2;

        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                res.append(s.charAt(j));
                int nextIdx = j + size - 2 * i;
                if (i != 0 && i != nRows - 1 && nextIdx < s.length()) {
                    res.append(s.charAt(nextIdx));
                }
            }
        }

       return res.toString();
    }
}
