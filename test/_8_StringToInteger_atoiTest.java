import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _8_StringToInteger_atoiTest {
    _8_StringToInteger_atoi _8 = new _8_StringToInteger_atoi();

    @Test
    void myAtoi() {
        assertEquals(42, _8.myAtoi("42"));
        assertEquals(-42, _8.myAtoi("    -42"));
        assertEquals(4193, _8.myAtoi("4193 with words"));
        assertEquals(0, _8.myAtoi("words and 987"));
        assertEquals(-2147483648, _8.myAtoi("-91283472332"));
    }
}