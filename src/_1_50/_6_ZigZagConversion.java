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
 *
 * PAYPALISHIRING  3
 *
 * 0    4   8     12
 * 1  3 5 7 9  11 13
 * 2    6   10
 *
 * Explanation:  4
 * 0    6       12
 * 1  5 7    11 13   17
 * 2 4  8 10    14 16
 * 3    9       15
 *
 * Explanation:  5
 * 0     8            16
 * 1   7 9         15 17
 * 2  6  10     14    18
 * 3 5   11  13
 * 4     12
 *
 * nRows = 5
 *
 * i = 2 * nRows - 2
 */
public class _6_ZigZagConversion {
    /**
     * O(n)
     * @param s
     * @param nRows
     * @return
     */
    public String convert_my(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0) {
            return "";
        }

        if (nRows == 1) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int len = s.length();

        int size = 2 * nRows - 2;

        // for the ith row
        for (int i = 0; i < nRows; i++) {
            int first = i;
            int second = size - first;

            while (true) {
                if (first >= len) {
                    break;
                }

                res.append(s.charAt(first));
                first += size;

                // here rows is 0 -> nRows -1
                if (i != 0 && i != nRows - 1) {
                    if (second >= len) {
                        break;
                    }

                    res.append(s.charAt(second));
                    second += size;
                }
            }
        }

        return res.toString();
    }

    /**
     * O(n)
     * @param s
     * @return
     */
    public String convert(String s, int nRows) {
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

    public static void main(String[] args) {
        _6_ZigZagConversion test = new _6_ZigZagConversion();
        String s = "PAYPALISHIRING";

        System.out.println(test.convert_my(s, 5).equals(test.convert(s, 5)));
        System.out.println(test.convert_my(s, 4).equals(test.convert(s, 4)));
        System.out.println(test.convert_my(s, 3).equals(test.convert(s, 3)));
        System.out.println(test.convert_my(s, 1).equals(test.convert(s, 1)));
    }
}
