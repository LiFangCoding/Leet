package leet._51_100;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class _58_length_of_last_word {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }

        int last = s.length() - 1;
        int ans = 0;

        // last can == 0
        while (last >= 0 && s.charAt(last) == ' ') {
            last--;
        }

        // last can == 0
        while (last >= 0 && s.charAt(last) != ' ') {
            last--;
            ans++;
        }

        return ans;
    }
}
