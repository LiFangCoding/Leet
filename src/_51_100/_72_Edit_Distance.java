package _51_100;

public class _72_Edit_Distance {
    public static void main(String[] args) {
        _72_Edit_Distance test = new _72_Edit_Distance();
        System.out.println("exp is 3, true is " + test.minDistance("horse", "ros"));
    }

    public int minDistance(String s1, String s2) {
        /**
         * find the minimum number of operations required to convert word1 to word2.
         *
         * the first mth character of s1
         * the first nth character of s2
         * f[m][n] = f[m - 1][n] + 1; deletion
         *           f[m][n - 1] + 1; insertion
         *           f[m - 1][n - 1] + { s1.charAt(m) == s2.charAt(n) ? 0 : 1}
         *
         * res is f[len1][len2]
         */
        int len1 = s1.length();
        int len2 = s2.length();

        /**
         * f is 0,1,... len1
         *      0,1,.. len2
         */
        int[][] f = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            f[i][0] = i;
        }

        for (int i = 0; i <= len2; i++) {
            f[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                f[i][j] = f[i - 1][j] + 1;
                f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1));
            }
        }

        return f[len1][len2];
    }
}
