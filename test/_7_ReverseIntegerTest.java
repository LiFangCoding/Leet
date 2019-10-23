import _1_50._7_ReverseInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _7_ReverseIntegerTest {

    @Test
    void reverse() {
        assertEquals(1, _7_ReverseInteger.reverse(1));
        assertEquals(21, _7_ReverseInteger.reverse(12));
        assertEquals(1, _7_ReverseInteger.reverse(10));
        assertEquals(321, _7_ReverseInteger.reverse(123));

        assertEquals(-321, _7_ReverseInteger.reverse(-123));
        assertEquals(0, _7_ReverseInteger.reverse(Integer.MIN_VALUE));
    }
}