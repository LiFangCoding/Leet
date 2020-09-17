package leet._251_300;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note:
 * <p>
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * <p>
 * Follow up:
 * <p>
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 */
public class _275_H_Index2 {
    /**
     * T = logn
     * 由于数组是从小到大排好序的，所以我们的任务是：
     * 在数组中找一个最大的 h，使得后 h 个数大于等于 h。
     * <p>
     * 我们发现：如果 h 满足，则小于 h 的数都满足；如果 h 不满足，则大于 h 的数都不满足。所以具有二分性质。
     * 直接二分即可。 找到最大的ah >= h.
     *
     * @param c
     * @return
     */
    public int hIndex(int[] c) {
        // already sorted when given
        int n = c.length;
        int l = 0, r = n;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (c[n - mid] >= mid)
                l = mid;
                // here r need -1
            else
                r = mid - 1;
        }

        return l;
    }
}
