package _201_250;

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * Example 1:
 * <p>
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: "dcbabcd"
 */
public class _214_Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();

        String t = new StringBuilder(s).reverse().toString();
        s = ' ' + s + '#' + t;
        char[] sa = s.toCharArray();

        int[] ne = new int[n * 2 + 2];
        for (int i = 2, j = 0; i <= n * 2 + 1; i++) {
            while (j != 0 && sa[i] != sa[j + 1]) j = ne[j];
            if (sa[i] == sa[j + 1]) j++;
            ne[i] = j;
        }

        int len = ne[n * 2 + 1];
        String left = s.substring(1, len + 1), right = s.substring(len + 1, n + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(right).reverse();
        sb.append(left);
        sb.append(right);
        return sb.toString();
    }
}
