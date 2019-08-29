import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _15_3SumTest {
    _15_3Sum test = new _15_3Sum();

    @Test
    void threeSum() {
        int[][] res = {{-1, 0 , 1}, {-1, -1, 2}};
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println(test.threeSum1(nums));
    }
}