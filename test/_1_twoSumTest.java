import leet._1_50._1_twoSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _1_twoSumTest {

    @Test
    void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = {0, 1};

        assertArrayEquals(res, _1_twoSum.twoSum(nums, target));
    }
}