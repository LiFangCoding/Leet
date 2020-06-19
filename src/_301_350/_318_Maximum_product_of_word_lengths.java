package _301_350;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 * <p>
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 * <p>
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _318_Maximum_product_of_word_lengths {
  /**
   * T = max(n2,n*L)
   * 9ms
   *
   * @param words
   * @return https://www.acwing.com/solution/content/340/
   * https://www.acwing.com/solution/content/349/
   * https://www.jiuzhang.com/problem/maximum-product-of-word-lengths/
   */
  public int maxProduct(String[] words) {
    if (words == null || words.length == 0)
      return 0;
    int len = words.length;
    int[] value = new int[len];
    for (int i = 0; i < len; i++) {
      String tmp = words[i];
      value[i] = 0;
      for (int j = 0; j < tmp.length(); j++) {
        value[i] |= 1 << (tmp.charAt(j) - 'a');
      }
    }
    int maxProduct = 0;
    for (int i = 0; i < len; i++)
      for (int j = i + 1; j < len; j++) {
        if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
          maxProduct = words[i].length() * words[j].length();
      }
    return maxProduct;
  }
}
