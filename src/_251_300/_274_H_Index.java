package _251_300;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class _274_H_Index {
    /**
     * 1ms
     * T = nlogn
     * 我们要在数组中找一个最大的 h，使得有 h 个数大于等于 h。
     * <p>
     * 我们可以先将原数组从小到大排序，然后从大到小枚举 h，直到数组中后 h 个数大于等于 h 为止。
     * <p>
     * 时间复杂度分析：排序的时间复杂度是 O(nlogn)，扫描的时间复杂度是 O(n)。所以总时间复杂度是 O(nlogn)
     * https://www.acwing.com/solution/content/329/
     */
    class Sol_sort {
        public int hIndex(int[] c) {
            if (c == null || c.length == 0)
                return 0;
            int n = c.length;
            Arrays.sort(c);
            for (int h = n; h >= 1; h--) {
                // make sure n - h is in array. So can only h == 1
                if (c[n - h] >= h)
                    return h;
            }
            return 0;
        }
    }
}
