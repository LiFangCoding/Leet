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
    String vs = "aeiouAEIOU";

    private boolean check(char c) {
        return vs.contains(String.valueOf(c));
    }

    public String reverseVowels(String str) {
        char[] s = str.toCharArray();
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            while (i < j && !check(s[i])) {
                i++;
            }

            while (i < j && !check(s[j])) {
                j--;
            }

            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return String.valueOf(s);
    }
}
