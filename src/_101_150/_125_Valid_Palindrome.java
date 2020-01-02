package _101_150;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class _125_Valid_Palindrome {
    public static void main(String[] args) {
        _125_Valid_Palindrome test = new _125_Valid_Palindrome();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(test.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] chars = s.toLowerCase().toCharArray();
        int len = chars.length;

        int i = 0;
        int j = len - 1;

        while (i < j) {
            while (i < j && !isValid(chars[i])) {
                i++;
            }

            while (i < j && !isValid(chars[j])) {
                j--;
            }

            if (chars[i] != chars[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
