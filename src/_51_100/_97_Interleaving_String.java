package _51_100;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class _97_Interleaving_String {
    public static void main(String[] args) {
        _97_Interleaving_String test = new _97_Interleaving_String();
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    /**
     * sequence question.
     * f[i][j] 表示 s1 的前 ii 个字符和 s2 的前 jj 个字符是否可以交错组成 s3 的前 i+ji+j 个字符
     * f[i][j]= {f[i-1][j] (if s3[i + j] = s1[i]) || f[i][j - 1] (if s3[i + j] = s2[j])}
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        boolean[][] f = new boolean[len1 + 1][len2 + 1];

        f[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            /**
             * charAt(i - 1) is the ith num
             */
            f[i][0] = f[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= len2; i++) {
            f[0][i] = f[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                f[i][j] = false;
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] = f[i][j] || f[i - 1][j];
                }

                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    f[i][j] = f[i][j] || f[i][j - 1];
                }
            }
        }
        return f[len1][len2];
    }
}
