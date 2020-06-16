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
     * oms
     * T = N
     * 求出一个后缀和数组，这个数组下标i对应的数表示大于等于i的数字出现的次数，这个数组可以O(n)求出 然后从大到小枚举这些数，找到最大的满足条件的数即可 总复杂度O(n)
     */
    class Sol_suffix {
        public int hIndex(int[] citations) {
            // write your code here

            int length = citations.length;
            if (length == 0) {
                return 0;
            }

            int[] array2 = new int[length + 1];

            for (int i = 0; i < length; i++) {
                if (citations[i] > length) {
                    array2[length] += 1;
                } else {
                    array2[citations[i]] += 1;
                }
            }

            int t = 0;

            for (int i = length; i >= 0; i--) {
                t = t + array2[i];
                if (t >= i) {
                    return i;
                }
            }
            return 0;
        }
    }

    /**
     * 1ms
     * T = nlogn
     * 我们要在数组中找一个最大的 hh，使得有 hh 个数大于等于 hh。
     * <p>
     * 我们可以先将原数组从小到大排序，然后从大到小枚举 hh，直到数组中后 hh 个数大于等于 hh 为止。
     * <p>
     * 时间复杂度分析：排序的时间复杂度是 O(nlogn)O(nlogn)，扫描的时间复杂度是 O(n)O(n)。所以总时间复杂度是 O(nlogn)O(nlogn)
     * https://www.acwing.com/solution/content/329/
     */
    class Sol_sort {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int ans = 0;

            for (int i = 0; i < citations.length; i++) {
                if (citations.length - i <= citations[i]) {
                    ans = citations.length - i;
                    break;
                }
            }

            return ans;
        }
    }
}
