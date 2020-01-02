package _101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 */
public class _131_Palindrome_Partitioning {
    List<List<String>> res;
    List<String> path;

    public static void main(String[] args) {
        _131_Palindrome_Partitioning test = new _131_Palindrome_Partitioning();
        System.out.println(test.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        path = new ArrayList<>();

        if (s == null) {
            return res;
        }

        /**
         * Use the chars array will improve from 4ms to 1ms and beat 100%
         */
        search(s.toCharArray(), 0);
        return res;
    }

    private void search(char[] chars, int start) {
        /**
         * base case. return
         */
        if (start == chars.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            if (isValid(chars, start, i)) {
                path.add(new String(chars, start, i + 1 - start));
                search(chars, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }

        return true;
    }
}
