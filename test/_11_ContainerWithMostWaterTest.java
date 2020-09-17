import leet._1_50._11_ContainerWithMostWater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _11_ContainerWithMostWaterTest {
    _11_ContainerWithMostWater test = new _11_ContainerWithMostWater();

    @Test
    void maxArea() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        assertEquals(49, test.maxArea(height));
        assertEquals(49, test.maxArea2(height));
    }
}