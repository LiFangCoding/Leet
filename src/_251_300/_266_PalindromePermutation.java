package _251_300;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "code"
 * Output: false
 * Example 2:
 * <p>
 * Input: "aab"
 * Output: true
 * Example 3:
 * <p>
 * Input: "carerac"
 * Output: true
 */
public class _266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return true;
        }

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for (char c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() <= 1;
    }
}
