package leet._51_100;

import java.util.ArrayList;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 * <p>
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 * <p>
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 * <p>
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _68_Text_Justification {
    // TODO
    public ArrayList<String> fullJustify(String[] words, int L) {
        //获取单次数量
        int wordsCount = words.length;
        //统计答案
        ArrayList<String> result = new ArrayList<String>();
        int curLen = 0;
        int lastI = 0;
        for (int i = 0; i <= wordsCount; i++) {
            if (i == wordsCount || curLen + words[i].length() + i - lastI > L) {
                //判断单行是否允许再放一个单词
                StringBuffer buf = new StringBuffer();
                int spaceCount = L - curLen;
                int spaceSlots = i - lastI - 1;
                if (spaceSlots == 0 || i == wordsCount) {
                    for (int j = lastI; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(buf, 1);
                        }
                    }
                    appendSpace(buf, L - buf.length());
                } else {
                    //如果不能，计算空格的数量和位置
                    int spaceEach = spaceCount / spaceSlots;
                    int spaceExtra = spaceCount % spaceSlots;
                    for (int j = lastI; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                        }
                    }
                }
                result.add(buf.toString());
                lastI = i;
                curLen = 0;
            }
            if (i < wordsCount) {
                curLen += words[i].length();
            }
        }
        return result;
    }

    private void appendSpace(StringBuffer sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }
}
