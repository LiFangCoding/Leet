import _1_50._3_longestSubstring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _3_longestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        String s = "abba";
        assertEquals(2, _3_longestSubstring.lengthOfLongestSubstring(s));

        s = "abcd";
        assertEquals(4, _3_longestSubstring.lengthOfLongestSubstring(s));

        s = "bbb";
        assertEquals(1, _3_longestSubstring.lengthOfLongestSubstring(s));

        s = "";
        assertEquals(0, _3_longestSubstring.lengthOfLongestSubstring(s));
    }

    @Test
    void lengthOfLongestSubstring2() {
        String s = "abba";
        assertEquals(2, _3_longestSubstring.lengthOfLongestSubstring2(s));

        s = "abcd";
        assertEquals(4, _3_longestSubstring.lengthOfLongestSubstring2(s));

        s = "bbb";
        assertEquals(1, _3_longestSubstring.lengthOfLongestSubstring2(s));

        s = "";
        assertEquals(0, _3_longestSubstring.lengthOfLongestSubstring2(s));
    }
}