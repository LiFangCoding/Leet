import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _9_PalindromNumberTest {
    _9_PalindromNumber test = new _9_PalindromNumber();
    @Test
    void isPalindrome() {
        assertTrue(test.isPalindrome1( 121));
        assertFalse(test.isPalindrome1( -121));
        assertFalse(test.isPalindrome1( -121));
        assertFalse(test.isPalindrome1( 1000021));
    }
}