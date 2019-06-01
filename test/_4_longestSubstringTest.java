import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _4_longestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        String s = "abba";
        assertEquals(2, _4_longestSubstring.lengthOfLongestSubstring(s));

        s = "abcd";
        assertEquals(4, _4_longestSubstring.lengthOfLongestSubstring(s));

        s = "bbb";
        assertEquals(1, _4_longestSubstring.lengthOfLongestSubstring(s));

        s = "";
        assertEquals(0, _4_longestSubstring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring2() {
        String s = "abba";
        assertEquals(2, _4_longestSubstring.lengthOfLongestSubstring2(s));

        s = "abcd";
        assertEquals(4, _4_longestSubstring.lengthOfLongestSubstring2(s));

        s = "bbb";
        assertEquals(1, _4_longestSubstring.lengthOfLongestSubstring2(s));

        s = "";
        assertEquals(0, _4_longestSubstring.lengthOfLongestSubstring2(s));
    }
}