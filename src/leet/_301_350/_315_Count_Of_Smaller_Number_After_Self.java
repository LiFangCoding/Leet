package leet._301_350;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        discretization(nums);

        // build bit array
        int[] bit = new int[nums.length + 1];
        int[] count = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            count[i] = getSum(bit, nums[i] - 1);
            update(bit, nums[i]);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }

        return result;
    }

    // this is nlogn
    // sort the orignal array and mapping the number to
    // the order in the sorted array;
    private void discretization(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }
    }

    private void update(int[] bit, int index) {
        for (int i = index; i < bit.length; i = i + lowbit(i)) {
            bit[i]++;
        }
    }

    private int getSum(int[] bit, int index) {
        int sum = 0;
        for (int i = index; i > 0; i = i - lowbit(i)) {
            sum += bit[i];
        }
        return sum;
    }

    private int lowbit(int x) {
        return x & (-x);
    }
}
