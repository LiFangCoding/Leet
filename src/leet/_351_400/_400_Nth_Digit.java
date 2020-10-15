package leet._351_400;

public class _400_Nth_Digit {
    public int findNthDigit(int n) {
        // k是第几位数， t是有多少个几位数
        // s是k位数的起始值
        int k = 1, t = 9, s = 1;
        while (n > (long) k * t) {
            n -= k * t;
            k++;
            t *= 10;
            s *= 10;
        }

        s += (n + k - 1) / k - 1;
        n = (n % k != 0) ? n % k : k;
        return String.valueOf(s).charAt(n - 1) - '0';
    }
}
