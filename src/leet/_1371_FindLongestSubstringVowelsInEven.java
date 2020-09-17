package leet;

/**
 * Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
 * Example 2:
 * <p>
 * Input: s = "leetcodeisgreat"
 * Output: 5
 * Explanation: The longest substring is "leetc" which contains two e's.
 * Example 3:
 * <p>
 * Input: s = "bcbcbc"
 * Output: 6
 * Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s contains only lowercase English letters.
 */

public class _1371_FindLongestSubstringVowelsInEven {
    //TODO
//    public int findTheLongestSubstring(String s) {
//        char[] A = s.toCharArray();
//
//        int ans = 0;
//        int len = A.length;
//        int l = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        map.put('a', 0);
//        map.put('e', 0);
//        map.put('i', 0);
//        map.put('o', 0);
//        map.put('u', 0);
//
//        for (int r = 0; r < len; r++) {
//            if (map.containsKey(A[r])) {
//                map.put(A[r], map.getOrDefault(A[r], 0) + 1);
//            }
//
//            if (isEven(map)) {
//                ans = Math.max(ans, r - l + 1);
//            }
//        }
//
//        return ans;
//    }
//
//    private boolean isEven(Map<Character, Integer> map) {
//        String s = "aeiou";
//
//        for (char c : s.toCharArray()) {
//            if (map.get(c) % 2 != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
