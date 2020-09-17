package leet._51_100;

import java.util.Arrays;
import java.util.HashMap;

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
 */

public class _87_Scramble_String {
    //TODO

    /**
     * T = n ^ 5
     * 递归判断两个字符串是否可以相互转化。
     * <p>
     * 首先判断两个字符串的字符集合是否相同，如果不同，则两个字符串一定不可以相互转化。
     * 然后枚举第一个字符串左半部分的长度，分别递归判断两种可能的情况：
     * <p>
     * 该节点不发生翻转，则分别判断两个字符串的左右两部分是否分别可以相互转化；
     * 该节点发生翻转，则分别判断第一个字符串的左边是否可以和第二个字符串的右边相互转化，且第一个字符串的右边可以和第二个字符串的左边相互转化；
     * 时间复杂度分析：设 anan 表示两个字符串长度是 nn 时的计算量，则根据递归函数，可知在最坏情况下：an=4∑n−1k=1akan=4∑k=1n−1ak，列项相减可以得到 an=5an−1an=5an−1，所以 an=5nan=5n。所以时间复杂度是 O(5n)O(5n)。
     * <p>
     * 作者：yxc
     * 链接：https://www.acwing.com/solution/content/170/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    // TODO Has error
    class Sol_dfs {
        public boolean isScramble(String s1, String s2) {
            if (s1 == s2) {
                return true;
            }

            char[] ch1 = s1.toCharArray();
            Arrays.sort(ch1);
            String ss1 = String.valueOf(ch1);

            char[] ch2 = s2.toCharArray();
            Arrays.sort(ch2);
            String ss2 = String.valueOf(ch2);

            if (!s1.equals(s2)) {
                return false;
            }

            for (int i = 1; i < s1.length(); i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                    return true;
                }
                if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                    return true;
            }
            return false;
        }
    }

    class Sol_memo_recur {
        HashMap<String, Boolean> hash = new HashMap<String, Boolean>();

        public boolean isScramble(String s1, String s2) {
            // Write your code here
            if (s1.length() != s2.length())
                return false;

            String key = s1 + "#" + s2;
            if (hash.containsKey(key))
                return hash.get(key);

            int n = s1.length();
            if (n == 1) {
                return s1.charAt(0) == s2.charAt(0);
            }

            for (int k = 1; k < n; ++k) {
                if (isScramble(s1.substring(0, k), s2.substring(0, k)) && isScramble(s1.substring(k, n), s2.substring(k, n)) || isScramble(s1.substring(0, k), s2.substring(n - k, n)) && isScramble(
                    s1.substring(k, n), s2.substring(0, n - k))) {
                    hash.put(key, true);
                    return true;
                }
            }
            hash.put(key, false);
            return false;
        }
    }
}
