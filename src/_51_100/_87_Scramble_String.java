package _51_100;

public class _87_Scramble_String {
    //TODO

    /**
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
     * <p>
     * Below is one possible representation of s1 = "great":
     * <p>
     * great
     * /    \
     * gr    eat
     * / \    /  \
     * g   r  e   at
     * / \
     * a   t
     * To scramble the string, we may choose any non-leaf node and swap its two children.
     * <p>
     * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
     * <p>
     * rgeat
     * /    \
     * rg    eat
     * / \    /  \
     * r   g  e   at
     * / \
     * a   t
     * We say that "rgeat" is a scrambled string of "great".
     * <p>
     * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
     * <p>
     * rgtae
     * /    \
     * rg    tae
     * / \    /  \
     * r   g  ta  e
     * / \
     * t   a
     * We say that "rgtae" is a scrambled string of "great".
     * <p>
     * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
     * <p>
     * Example 1:
     * <p>
     * Input: s1 = "great", s2 = "rgeat"
     * Output: true
     * Example 2:
     * <p>
     * Input: s1 = "abcde", s2 = "caebd"
     * Output: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/scramble-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        return false;
    }
}
