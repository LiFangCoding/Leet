import leet._1_50._13_RomanToInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _13_RomanToIntegerTest {
    _13_RomanToInteger test = new _13_RomanToInteger();

    @Test
    void romanToInt() {
        assertEquals(3, test.romanToInt("III"));
        assertEquals(4, test.romanToInt("IV"));
        assertEquals(9, test.romanToInt("IX"));
        assertEquals(58, test.romanToInt("LVIII"));
        assertEquals(1994, test.romanToInt("MCMXCIV"));
    }
}