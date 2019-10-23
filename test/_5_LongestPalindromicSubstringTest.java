import _1_50._5_LongestPalindromicSubstring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _5_LongestPalindromicSubstringTest {

    @Test
    void longestPalindrome() {
        String s = "babad";

        assertEquals("bab", _5_LongestPalindromicSubstring.longestPalindrome(s));

        s = "aaaaa";
        assertEquals(s, _5_LongestPalindromicSubstring.longestPalindrome(s));

        s = "abcd";
        assertEquals("a", _5_LongestPalindromicSubstring.longestPalindrome(s));
    }
}