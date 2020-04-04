package _251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 * <p>
 * Example:
 * <p>
 * Input: s = "++++"
 * Output:
 * [
 * "--++",
 * "+--+",
 * "++--"
 * ]
 * Note: If there is no valid move, return an empty list [].
 */
public class _293_FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return ans;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len - 1; i++) {
            if (chars[i] == chars[i + 1] && chars[i] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                ans.add(new String(chars));
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }

        return ans;
    }
}
