package leet._301_350;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class _315_Count_Of_Smaller_Number_After_Self {
    //TODO: difficult

    /**
     * 9 ms
     * <p>
     * T = nlogn
     * 真正的 nlognnlogn 的算法
     * 首先使用离散化将原来的数组变为对应的 order 数组。这样就不会有负数，也不会有特别大的数。
     * 如：[1, 1000, -100, 10, 100]，将每个数替换为在整个数组中对应的排序。如，1是从小到大第2个，那么就替换为 2。
     * 替换之后得到数组 [2, 5, 1, 3, 4]。
     * <p>
     * 接着在用 Binary Indexed Tree 来统计每个数右边有多少个数比他小，只需要从右到左遍历这个数组，一边把数丢到 BIT 里一边计算就行了。
     * https://www.jiuzhang.com/solution/count-of-smaller-numbers-after-self/#tag-highlight
     */
    // 树状数组需要从1开始
    // 树状数组长度
    class Solution {
        // 树状数组需要从1开始
        // 树状数组长度
        int n = 20001;
        int[] tr = new int[n + 1];

        int lowbit(int x) {
            return x & -x;
        }

        int query(int x) {
            int res = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                res += tr[i];
            }
            return res;
        }

        void add(int x, int v) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tr[i] += v;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            int len = nums.length;

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                res.add(0);
            }
            for (int i = len - 1; i >= 0; i--) {
                int x = nums[i] + 10001;
                res.set(i, query(x - 1));
                add(x, 1);
            }
            return res;
        }
    }
}
