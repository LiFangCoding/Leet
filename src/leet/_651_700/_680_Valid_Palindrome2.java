package leet._651_700;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class _680_Valid_Palindrome2 {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] A = s.toCharArray();
        int len = A.length;
        int l, r;
        for (l = 0, r = len - 1; l < r; ) {
            if (A[l] == A[r]) {
                l++;
                r--;
            } else {
                break;
            }
        }

        if (l >= r) {
            return true;
        }

        return valid(A, l + 1, r) || valid(A, l, r - 1);
    }

    private boolean valid(char[] A, int l, int r) {
        while (l < r) {
            if (A[l] == A[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}
