package leet._301_350;

/**
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 * <p>
 * Note: You should try to optimize your time and space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 * <p>
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * Example 3:
 * <p>
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _321_Create_Maximum_number {
    /**
     * 10ms
     * T = N ^ 3
     * https://www.jiuzhang.com/problem/create-maximum-number/#tag-highlight-lang-java
     * https://www.acwing.com/solution/content/347/
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // Write your code here
        if (k == 0)
            return new int[0];

        int m = nums1.length, n = nums2.length;
        if (m + n < k)
            return null;
        if (m + n == k) {
            int[] results = merge(nums1, nums2, k);
            return results;
        } else {
            int max = m >= k ? k : m;
            int min = n >= k ? 0 : k - n;

            int[] results = new int[k];
            for (int i = 0; i < k; ++i)
                results[i] = -0x7ffffff;
            for (int i = min; i <= max; ++i) {
                int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
                results = isGreater(results, 0, temp, 0) ? results : temp;
            }
            return results;
        }
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] results = new int[k];
        if (k == 0)
            return results;
        int i = 0, j = 0;
        for (int l = 0; l < k; ++l) {
            results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return results;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        for (; i < nums1.length && j < nums2.length; ++i, ++j) {
            if (nums1[i] > nums2[j])
                return true;
            if (nums1[i] < nums2[j])
                return false;
        }
        return i != nums1.length;
    }

    private int[] getMax(int[] nums, int k) {
        if (k == 0)
            return new int[0];
        int[] results = new int[k];
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            while (nums.length - j + i > k && i > 0 && results[i - 1] < nums[j])
                i--;
            if (i < k)
                results[i++] = nums[j];
        }
        return results;
    }
}
