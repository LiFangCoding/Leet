import _1_50._16_3SumClosest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _16_3SumClosestTest {
    _16_3SumClosest test = new _16_3SumClosest();

    @Test
    void threeSumClosest() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        assertEquals(2, test.threeSumClosest(nums, target));
    }
}