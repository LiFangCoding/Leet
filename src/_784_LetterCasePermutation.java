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
    StringBuilder cur;

    public List<String> letterCasePermutation(String S) {
        ans = new ArrayList<>();

        char[] chars = S.toCharArray();
        dfs(chars, 0);
        return ans;
    }

    private void dfs(char[] chars, int s) {
        if (cur.length() == chars.length) {
            ans.add(cur.toString());
            return;
        }

        if (Character.isDigit(chars[s])) {
            cur.append(chars[s]);
            dfs(chars, s + 1);
        } else {
            char c = chars[s];
            int dis = ((c - 'a') >= 0 && (c - 'a') < 26) ? c - 'a' : c - 'A';

            cur.append((char) (dis + 'a'));
            dfs(chars, s + 1);
            cur.deleteCharAt(cur.length() - 1);

            cur.append((char) (dis + 'A'));
            dfs(chars, s + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
