import leet._1_50._6_ZigZagConversion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _6_ZigZagConversionTest {
    _6_ZigZagConversion test = new _6_ZigZagConversion();

    @Test
    void test() {
        assertEquals("04135726", test.convert("01234567", 3));

        String s = "PAYPALISHIRING";
        assertEquals("PAHNAPLSIIGYIR", test.convert(s, 3));

        s = "PAYPALISHIRING";
        assertEquals("PINALSIGYAHRPI", test.convert(s, 4));
    }
}