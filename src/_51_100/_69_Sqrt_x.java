package _51_100;

public class _69_Sqrt_x {
    public static void main(String[] args) {
        _69_Sqrt_x test = new _69_Sqrt_x();
        System.out.println(test.mySqrt(9));
        System.out.println(test.mySqrt(10));
        System.out.println(test.mySqrt(0));
        System.out.println(test.mySqrt(3));
        System.out.println(test.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        /**
         * find largest res one that res * res <= x
         */
        int start = 1;
        int end = x;

        /**
         * !!! Integer multiply overflow. Pay attention.
         */
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (end <= x / end) {
            return end;
        }

        return start;
    }
}
