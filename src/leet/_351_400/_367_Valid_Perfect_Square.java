package leet._351_400;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Follow up: Do not use any built-in library function such as sqrt.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: num = 16
 * Output: true
 * Example 2:
 * <p>
 * Input: num = 14
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _367_Valid_Perfect_Square {
    // 二分找root, 下取整，是否有相乘的
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // overflow
            if (mid <= num / mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l * l == num;
    }
}
