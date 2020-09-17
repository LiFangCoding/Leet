package leet._151_200;

/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 * <p>
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *  
 * <p>
 * Note:
 * <p>
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 */
public class _191_Numberof1Bits {
    class Sol_lowbit {
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                n -= n & -n;
                res++;
            }
            return res;
        }
    }

    class Sol_linear {
        public int hammingWeight(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res += n >> i & 1;
            }
            return res;
        }
    }
}

