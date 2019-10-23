import _1_50._12_IntegerToRoman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _12_IntegerToRomanTest {
    _12_IntegerToRoman test = new _12_IntegerToRoman();

    @Test
    void intToRoman() {
        assertEquals("III", test.intToRoman(3));
        assertEquals("IV", test.intToRoman(4));
        assertEquals("IX", test.intToRoman(9));
        assertEquals("LVIII", test.intToRoman(58));
        assertEquals("MCMXCIV", test.intToRoman(1994));
    }
}