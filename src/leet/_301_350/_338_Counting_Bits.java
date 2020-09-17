package leet._301_350;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class _338_Counting_Bits {
    /**
     * 2 ms
     * T = n
     * S = n
     * https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
     */
    class Sol_OddEven {
        /**
         * 很简单啊，不用多说，设dp[i]为i的二进制形式的1的个数，i是奇数时，dp[i]=dp[i-1]+1,因为i是在i-1的二进制数上加了个1啊；i是偶数时，dp[i]=dp[i/2],因为i就是把i/2往左移（是数左移，末尾补0）得到的，所以1的个数没变
         * <p>
         * 作者：jin-ai-yi
         * 链接：https://leetcode-cn.com/problems/counting-bits/solution/zhe-ying-gai-shi-dao-easyti-ba-wei-yun-suan-ji-chu/
         * 来源：力扣（LeetCode）
         */

        public int[] countBits(int num) {
            int[] f = new int[num + 1];

            f[0] = 0;
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 1) {
                    f[i] = f[i - 1] + 1;
                } else {
                    f[i] = f[i / 2];
                }
            }

            return f;
        }
    }

    /**
     * 3ms
     * T = nk.对于每个整数 xx，我们需要 O(k)O(k) 次操作，其中 kk 是 xx 的位数。
     * S = n
     * https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
     */
    class Sol_Brute {
        public class Solution {
            public int[] countBits(int num) {
                int[] ans = new int[num + 1];
                for (int i = 0; i <= num; ++i) {
                    ans[i] = popcount(i);

                }
                return ans;
            }

            private int popcount(int x) {
                int count;
                for (count = 0; x != 0; ++count) {
                    x &= x - 1; //zeroing out the least significant nonzero bit
                }
                return count;
            }
        }
    }
}
