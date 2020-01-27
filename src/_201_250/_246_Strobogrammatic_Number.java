package _201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input:  "69"
 * Output: true
 * Example 2:
 * <p>
 * Input:  "88"
 * Output: true
 * Example 3:
 * <p>
 * Input:  "962"
 * Output: false
 */
public class _246_Strobogrammatic_Number {
    public boolean isStrobogrammatic(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');
        map.put('1', '1');

        for (int l = 0, r = len - 1; l <= r; l++, r--) {
            if (!map.containsKey(chars[l])) {
                return false;
            }

            if (!map.containsKey(chars[r])) {
                return false;
            }

            /**
             * !!! need !.
             */
            if (!map.get(chars[l]).equals(chars[r])) {
                return false;
            }
        }

        return true;
    }

}
