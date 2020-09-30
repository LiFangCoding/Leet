package leet._301_350;

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
     * @param words
     * @return https://www.acwing.com/solution/content/340/
     * https://www.acwing.com/solution/content/349/
     * https://www.jiuzhang.com/problem/maximum-product-of-word-lengths/
     */
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int s = 0;
            for (char c : word.toCharArray()) {
                s |= 1 << (c - 'a');
            }
            state[i] = s;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((state[i] & state[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}
