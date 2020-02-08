package _251_300;

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
    private Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (s == null) {
            return false;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len - 1; i++) {
            if (chars[i] == chars[i + 1] && chars[i] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                String nextStr = new String(chars);
                chars[i] = '+';
                chars[i + 1] = '+';

                boolean nextwin = false;
                if (map.containsKey(nextStr)) {
                    nextwin = map.get(nextStr);
                } else {
                    nextwin = canWin(nextStr);
                    map.put(nextStr, nextwin);
                }

                if (!nextwin) {
                    return true;
                }
            }
        }

        return false;
    }
}
