package leet._301_350;

/**
 * Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * <p>
 * Example:
 * <p>
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 * <p>
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _313_Super_Ugly_Number {
    /**
     * 18ms
     * T = n * k
     * https://www.acwing.com/solution/content/92/
     * https://www.jiuzhang.com/problem/super-ugly-number/
     */
    class Sol_track {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int len = primes.length;
            int dp[] = new int[n];
            dp[0] = 1;
            /*梳理一下思路，dp[i]保存的是第i个超级丑数*/
        /*index[i]表示的是primes里面的第i个数下一个将要相乘的数在dp中的位置，
        反过来想，对于每个primes来说，我们都需要和dp中已经算出来的结果相乘算，
        然后取最小的那个作为新的dp元素
        索引index实际上表示是这个素数已经和dp中的哪个位置结合了，下一个位置的坐标是多少 */
            int index[] = new int[len];
            /*可能存在重复的丑数，所以呢，不要在for循环里面加break，把所有的情况都+1*/
            for (int i = 1; i < n; i++) {
                int min = Integer.MAX_VALUE;
                /*遍历对比一下值，找出最小的，*/
                for (int j = 0; j < len; j++) {
                    if (min > primes[j] * dp[index[j]]) {
                        min = primes[j] * dp[index[j]];//这个地方就是当前质因数和他要结合的dp
                    }
                }
                dp[i] = min;
                /*那个素数要乘以dp的坐标index要加1，向后推一个位
                 * 如果存在重复的值，也就是说不同的质因数相乘，得出来相同的结果了，
                 * 我们就把这几个位置都+1，这样就可以避免出现重复的值了。
                 * 你想想，假如你找到了对应的素数的index，把它加1之后就break掉，那么后面的数也可以算出这个结果，
                 * 下次循环的时候，势必会把这个重复的数当成下一个dp，因为这个数肯定要比下一个丑数小
                 * 所以我们在for循环中不要加break；*/
                for (int j = 0; j < len; j++) {
                    if (min == primes[j] * dp[index[j]]) {
                        index[j]++;
                    }
                }

            }
            return dp[n - 1];
        }
        //
        //    作者：xiao-xin-28
        //    链接：https://leetcode-cn.com/problems/super-ugly-number/solution/javazui-rong-yi-li-jie-de-dong-tai-gui-hua-fen-xi-/
        //    来源：力扣（LeetCode）
        //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}
