/**
 * We have a collection of rocks, each rock has a positive integer weight.
 * <p>
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
public class _1049_Last_Stone_Weight2 {
    // 作者：Jiachen_Zhang
// 链接：https://leetcode-cn.com/problems/last-stone-weight-ii/solution/dong-tai-gui-hua-bei-bao-wen-ti-xiang-jie-by-jiach/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int lastStoneWeightII(int[] stones) {
        /* 由于石头拿走还能放回去，因此可以简单地把所有石头看作两堆
         * 假设总重量为 sum, 则问题转化为背包问题：如何使两堆石头总重量接近 sum / 2
         */
        int len = stones.length;
        /* 获取石头总重量 */
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }

        /* 定义 dp[i] 重量上限为 i 时背包所能装载的最大石头重量 */
        int maxCapacity = sum / 2;
        int[] dp = new int[maxCapacity + 1];
        for (int i = 0; i < len; i++) {
            int curStone = stones[i];
            System.out.println("cur Stone is " + curStone);
            for (int j = maxCapacity; j >= curStone; j--) {
                dp[j] = Math.max(dp[j], dp[j - curStone] + curStone);
                System.out.printf(" dp[%d] is %d, dp[%d] is %d%n", j - curStone, dp[j - curStone], j, dp[j]);
            }
        }
        return sum - 2 * dp[maxCapacity];
    }
}
