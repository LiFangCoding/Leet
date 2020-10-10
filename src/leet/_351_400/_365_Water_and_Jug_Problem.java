package leet._351_400;

public class _365_Water_and_Jug_Problem {
    // 求最大公约数能否整除
    // ax + by = c.
    // (a, b) / c
    public boolean canMeasureWater(int a, int b, int c) {
        if (c > a + b) return false;
        if (c < 0) return false;
        return c == 0 || c % gcd(a, b) == 0;
    }

    //1,3
    // 3, 1
    // 1, 0
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
