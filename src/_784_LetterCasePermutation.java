import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class _784_LetterCasePermutation {
    List<String> ans;

    public List<String> letterCasePermutation(String str) {
        ans = new ArrayList<>();
        char[] chars = str.toCharArray();

        dfs(chars, 0);
        return ans;
    }

    private void dfs(char[] chars, int s) {
        if (s == chars.length) {
            ans.add(new String(chars));
            return;
        }

        if (Character.isDigit(chars[s])) {
            // here is need to remove the char at end
            dfs(chars, s + 1);
        } else {
            char temp = chars[s];

            chars[s] = Character.toLowerCase(temp);
            dfs(chars, s + 1);

            chars[s] = Character.toUpperCase(temp);
            dfs(chars, s + 1);

            chars[s] = temp;
        }
    }
}
