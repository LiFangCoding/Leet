package leet._1_50;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * <p>
 * PAYPALISHIRING  3
 * <p>
 * 0    4   8     12
 * 1  3 5 7 9  11 13
 * 2    6   10
 * <p>
 * Explanation:  4
 * 0    6       12
 * 1  5 7    11 13   17
 * 2 4  8 10    14 16
 * 3    9       15
 * <p>
 * Explanation:  5
 * 0     8            16
 * 1   7 9         15 17
 * 2  6  10     14    18
 * 3 5   11  13
 * 4     12
 * <p>
 * nRows = 5
 * <p>
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

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = i; j < len; j += dis) {
                    sb.append(sa[j]);
                }
            } else {
                for (int j = i, k = dis - i; j < len || k < len; j += dis, k += dis) {
                    if (j < len) {
                        sb.append(sa[j]);
                    }
                    if (k < len) {
                        sb.append(sa[k]);
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
