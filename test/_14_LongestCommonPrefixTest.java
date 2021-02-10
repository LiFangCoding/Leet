import leet._1_50._14_LongestCommonPrefix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _14_LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        String[] strs = {"flower","flow","flight"};
        assertEquals("fl", _14_LongestCommonPrefix.Sol_ac_sb.longestCommonPrefix(strs));

        String[] strs2 = {"dog","racecar","car"};
        assertEquals("", _14_LongestCommonPrefix.Sol_ac_sb.longestCommonPrefix(strs2));
    }
}