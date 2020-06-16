package _251_300;

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
     * 在数组中找一个最大的 hh，使得后 hh 个数大于等于 hh。
     * <p>
     * 我们发现：如果 hh 满足，则小于 hh 的数都满足；如果 hh 不满足，则大于 hh 的数都不满足。所以具有二分性质。
     * 直接二分即可。
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int l = 0, r = len - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (len - mid <= citations[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (len - l <= citations[l]) {
            return len - l;
        }

        if (len - r <= citations[r]) {
            return len - r;
        }

        return 0;
    }
}
