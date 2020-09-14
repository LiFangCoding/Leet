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
     *
     * @param s
     * @return
     */
    public String convert(String s, int n) {
        if (s == null || s.length() == 0 || n <= 0) {
            return "";
        }
        // special case n = 1. dis = 0. 超出内存限制
        if (n == 1) {
            return s;
        }

        int dis = 2 * n - 2;
        StringBuilder sb = new StringBuilder();
        char[] sa = s.toCharArray();
        int len = sa.length;

        for (int row = 0; row < n; row++) {
            if (row == 0 || row == n - 1) {
                for (int first = row; first < len; first += dis) {
                    sb.append(sa[first]);
                }
            } else {
                for (int first = row, second = dis - row; first < len || second < len; first += dis, second += dis) {
                    if (first < len) {
                        sb.append(sa[first]);
                    }
                    if (second < len) {
                        sb.append(sa[second]);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        _6_ZigZagConversion test = new _6_ZigZagConversion();
        String s = "PAYPALISHIRING";

        System.out.println(test.convert(s, 5).equals(test.convert(s, 5)));
        System.out.println(test.convert(s, 4).equals(test.convert(s, 4)));
        System.out.println(test.convert(s, 3).equals(test.convert(s, 3)));
        System.out.println(test.convert(s, 1).equals(test.convert(s, 1)));
    }
}
