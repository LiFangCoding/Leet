package leet._401_450;

public class _410_Split_Array_Largest_Sum {
    //非负整数
    // 判断是否有方案， 是每一段 <= mid 能够分成m段
    // 最小能分成多少段
    // 最大最小问题一般可以用二分来做
    boolean check(int[] nums, int m, int mid) {
        int sum = 0, cnt = 0;
        for (int x : nums) {
            if (x > mid) return false;
            if (sum + x > mid) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        if (sum != 0) cnt++;
        return cnt <= m;
    }

    public int splitArray(int[] nums, int m) {
        int l = 0, r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(nums, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
