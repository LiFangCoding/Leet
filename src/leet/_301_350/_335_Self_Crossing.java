package leet._301_350;

/**
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.
 * <p>
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * ┌───┐
 * │   │
 * └───┼──>
 *     │
 * <p>
 * Input: [2,1,1,2]
 * Output: true
 * Example 2:
 * <p>
 * ┌──────┐
 * │      │
 * │
 * │
 * └────────────>
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * ┌───┐
 * │   │
 * └───┼>
 * <p>
 * Input: [1,1,1,1]
 * Output: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-crossing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _335_Self_Crossing {
    /**
     * 0ms
     * T = n
     */
    public boolean isSelfCrossing(int[] x) {
        int n = x.length;
        if (n <= 3) {
            return false;
        }

        for (int i = 3; i < n; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }

            if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            }

            if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] + x[i - 5] >= x[i - 3] && x[i - 1] <= x[i - 3]) {
                return true;
            }
        }

        return false;
    }
}
