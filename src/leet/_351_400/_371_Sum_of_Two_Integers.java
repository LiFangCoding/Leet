package leet._351_400;

public class _371_Sum_of_Two_Integers {
    class Solution {
        // a + b = a ^ b 不进位加法 + 进位
        // 进位，看哪些位有进位，两个1， a & b. 往前进一位， 所以 (a & b) << 1 + a ^ b = a + b
        public int getSum(int a, int b) {
            if (a == 0) return b;
            int sum = a ^ b, carry = (a & b) << 1;
            return getSum(carry, sum);
        }
    }
}
