package leet._301_350;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] sa = s.toCharArray();
        int i = -1, j = s.length();

        while (true) {
            while (!isValid(sa[++i])) {
                // high is len - 1
                if (i == sa.length - 1) {
                    break;
                }
            }

            while (!isValid(sa[--j])) {
                // lo is 0
                if (j == 0) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(sa, i, j);
        }

        return String.valueOf(sa);
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        // need add
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean isValid(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}
