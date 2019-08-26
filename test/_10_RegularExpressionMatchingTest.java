import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _10_RegularExpressionMatchingTest {
    _10_RegularExpressionMatching test = new _10_RegularExpressionMatching();

    @Test
    void isMatch() {
        assertFalse(test.isMatch("aa", "a"));
        assertTrue(test.isMatch("aa", "a*"));
        assertTrue(test.isMatch("aab", "c*a*b*"));
        assertFalse(test.isMatch("mississippi", "mis*is*p*."));
    }
}