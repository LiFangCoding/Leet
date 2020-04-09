package _351_400;

public class _371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 当进位不为0时
            // 无进位累加值
            int temp = a ^ b;

            // 进位值
            int carry = (a & b) << 1;

            // a=无进位累加值 b=进位值
            a = temp;
            b = carry;
        }

        return a;
    }
}
