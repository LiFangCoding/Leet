package leet._401_450;

import java.text.DecimalFormat;

public class _414_Third_Maximum_Number {
    public static void main(String[] args) {
        long i = (long) 1e10;
        System.out.println(DecimalFormat.getIntegerInstance().format(1e10));
        System.out.println(1e10 > Integer.MAX_VALUE);
    }

    // 用三个值来表示a, b, c, a is max
    // x分情况判断
    // 边界情况处理 int min value
    public int thirdMax(int[] nums) {
        long INF = (long) 1e10;
        long a = -INF, b = -INF, c = -INF, s = 0;
        for (int x : nums) {
            if (x > a) {
                s++;
                c = b;
                b = a;
                a = x;
            } else if (x < a && x > b) {
                s++;
                c = b;
                b = x;
            } else if (x < b && x > c) {
                s++;
                c = x;
            }
        }
        // if not exist, return the max number
        if (s < 3) return (int) a;
        return (int) c;
    }
}
