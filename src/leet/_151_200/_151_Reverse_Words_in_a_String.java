package leet._151_200;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class _151_Reverse_Words_in_a_String {
    class Sol_ac {
        public String reverseWords(String s) {
            int k = 0;
            char[] sa = s.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (sa[i] == ' ') continue;
                int j = i, t = k;
                while (j < sa.length && sa[j] != ' ') {
                    sa[t++] = sa[j++];
                }
                for (int r = t - 1; r >= k; r--) {
                    sb.append(sa[r]);
                }
                sb.append(' ');

                k = t;
                i = j;
            }

            // 至少有一个单词，将最后的单词删掉
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.reverse().toString();
        }
    }

    class Sol_old {
        /**
         * Here already trim()
         * If we do not use trim()
         */

        public String reverseWords(String s) {

            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            reverse(chars, 0, chars.length - 1);

            int l = 0, r = 0;
            while (r < chars.length) {
                /**
                 * find the next word starting index that is not ' '
                 */
                while (r < chars.length && chars[r] == ' ') {
                    r++;
                }

                if (r == chars.length) {
                    break;
                }
                l = r;
                /**
                 * find next word end index
                 */
                while (r < chars.length && chars[r] != ' ') {
                    r++;
                }

                reverse(chars, l, r - 1);
                sb.append(new String(chars, l, r - l));
                System.out.println("new Strign is " + new String(chars, l, r - l));
                sb.append(' ');
            }

            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        }

        public void reverse(char[] chars, int start, int end) {
            int l = start, r = end;
            for (int i = start, j = end; i < j; i++, j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
        }
    }
}
