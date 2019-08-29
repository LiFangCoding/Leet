import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _18_4SumTest {
    _18_4Sum test = new _18_4Sum();
    int[][] result = {
            {-1,  0, 0, 1},
            {-2, -1, 1, 2},
            {-2,  0, 0, 2}
    };

    @Test
    void fourSum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(test.fourSum(nums, 0));
    }
}