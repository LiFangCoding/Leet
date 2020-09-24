package leet._351_400;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *  
 * <p>
 * Constraints:
 * <p>
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _383_Ransom_Note {
    public boolean canConstruct(String r, String m) {
        int[] map = new int[256];
        for (char c : m.toCharArray()) map[c]++;
        for (char c : r.toCharArray()) {
            map[c]--;
            if (map[c] < 0) return false;
        }
        return true;
    }
}
