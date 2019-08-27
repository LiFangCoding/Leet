import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _14_LongestCommonPrefixTest {
    _14_LongestCommonPrefix test = new _14_LongestCommonPrefix();

    @Test
    void longestCommonPrefix() {
        String[] strs = {"flower","flow","flight"};
        assertEquals("fl", test.longestCommonPrefix(strs));

        String[] strs2 = {"dog","racecar","car"};
        assertEquals("", test.longestCommonPrefix(strs2));
    }
}