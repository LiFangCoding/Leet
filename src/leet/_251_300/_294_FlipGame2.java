package leet._251_300;

import java.util.HashMap;
import java.util.Map;

/**
 * ou are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win.
 * <p>
 * Example:
 * <p>
 * Input: s = "++++"
 * Output: true
 * Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */
public class _294_FlipGame2 {
    Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1] && chars[i] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                String choice = new String(chars);
                chars[i] = '+';
                chars[i + 1] = '+';

                // canWin method will save into map directly, so no need to memo again
                if (!canWin(choice)) {
                    map.put(s, true);
                    return true;
                }
            }
        }

        map.put(s, false);
        return false;
    }
}
