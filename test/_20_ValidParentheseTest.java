import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _20_ValidParentheseTest {
    _20_ValidParenthese test = new _20_ValidParenthese();

    @Test
    void isValid() {
        assertTrue(test.isValid("()"));
        assertTrue(test.isValid("()[]{}"));
        assertFalse(test.isValid("(]"));
        assertFalse(test.isValid( "([)]"));
        assertTrue(test.isValid("{[]}"));
    }
}