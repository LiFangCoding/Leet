package _51_100;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class _88_Merge_Sorted_Array {
    public void merge(int[] A1, int m, int[] A2, int n) {
        int last = m + n - 1;

        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A1[i] > A2[j]) {
                A1[last--] = A1[i--];
            } else {
                A1[last--] = A2[j--];
            }
        }

        if (i < 0) {
            while (j >= 0) {
                A1[last--] = A2[j--];
            }
        }

        if (j < 0) {
            return;
        }
    }
}
