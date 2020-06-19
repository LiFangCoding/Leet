package _301_350;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word. 
 * <p>
 * Note: The order of the output does not matter.
 * <p>
 * Example:
 * <p>
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generalized-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _320_Generalized_Abbreviation {
  /**
   * 通过DFS对所有缩写的可能进行搜索，从字符串的第一个字符开始，依次搜索该字位符进行和不进行缩写操作后可能的情况，直到搜索至最后一位。
   */
  public List<String> generateAbbreviations(String word) {
    // Write your code here
    List<String> res = new ArrayList<String>();
    String cur = "";
    help(res, word, 0, cur, 0);

    return res;
  }

  private void help(List<String> res, String word, int pos, String cur, int count) {
    if (pos == word.length()) {
      if (count > 0) {
        cur += count;
      }
      res.add(cur);
    } else {
      help(res, word, pos + 1, cur, count + 1);
      if (count > 0) {
        cur = cur + count + word.charAt(pos);
      } else {
        cur = cur + word.charAt(pos);
      }
      help(res, word, pos + 1, cur, 0);
    }
  }
}
