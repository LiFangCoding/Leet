import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _6_ZigZagConversionTest {

    @Test
    void convert() {
        String s = "PAYPALISHIRING";
        assertEquals("PAHNAPLSIIGYIR", _6_ZigZagConversion.convert(s, 3));

        s = "PAYPALISHIRING";
        assertEquals("PINALSIGYAHRPI", _6_ZigZagConversion.convert(s, 3));

    }
}