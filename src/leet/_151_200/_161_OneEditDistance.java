package leet._151_200;

/**
 * Given two strings s and t, determine if they are both one edit distance apart.
 * <p>
 * Note: 
 * <p>
 * There are 3 possiblities to satisify one edit distance apart:
 * <p>
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * Example 1:
 * <p>
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * Example 2:
 * <p>
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * Example 3:
 * <p>
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 */
public class _161_OneEditDistance {
    public static void main(String[] args) {
        _161_OneEditDistance test = new _161_OneEditDistance();
        System.out.println(test.isOneEditDistance("a", "ac"));
        System.out.println(test.isOneEditDistance("ab", "acb"));
        System.out.println(test.isOneEditDistance("cab", "ad"));
        System.out.println(test.isOneEditDistance("1203", "1213"));
    }

    /**
     * "a"
     * ""
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int slen = s.length();
        int tlen = t.length();

        /**
         * s should always smaller or equal
         */
        if (slen > tlen) {
            return isOneEditDistance(t, s);
        }

        if ((tlen - slen) > 1) {
            return false;
        }

        for (int i = 0; i < slen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // if strings have the same length
                if (slen == tlen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                // if strings have different lengths
                else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        // If there is no diffs on ns distance
        // the strings are one edit away only if
        // t has one more character.
        return (slen + 1 == tlen);
    }
}
