import _1_50._6_ZigZagConversion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _6_ZigZagConversionTest {

    @Test
    void convert() {
        assertEquals("04135726", _6_ZigZagConversion.convert("01234567", 3));

        String s = "PAYPALISHIRING";
        assertEquals("PAHNAPLSIIGYIR", _6_ZigZagConversion.convert(s, 3));

        s = "PAYPALISHIRING";
        assertEquals("PINALSIGYAHRPI", _6_ZigZagConversion.convert(s, 4));

    }
}