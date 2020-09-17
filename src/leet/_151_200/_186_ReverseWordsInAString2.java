package leet._151_200;

/**
 * Given an input string , reverse the string word by word. 
 * <p>
 * Example:
 * <p>
 * Input:  ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
 * Output: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
 * Note: 
 * <p>
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 */
public class _186_ReverseWordsInAString2 {
    public static void main(String[] args) {
        _186_ReverseWordsInAString2 test = new _186_ReverseWordsInAString2();
        char[] chars = new char[] { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
        test.reverseWords(chars);
        System.out.println(chars);
    }

    public void reverseWords(char[] chars) {
        int l = 0;
        int r = 0;
        int len = chars.length;

        while (r < len) {
            while (r < len && chars[r] != ' ') {
                r++;
            }
            /**
             * !!! should be r - 1
             */
            reverse(chars, l, r - 1);
            r++;
            l = r;
        }

        reverse(chars, 0, len - 1);
    }

    private void reverse(char[] chars, int l, int r) {
        for (; l < r; l++, r--) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
        }
    }
}
