package leet._1_50;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class _4_MedianOfTwoSortedArrays {
    //TODO
    class Sol_ac {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int tot = nums1.length + nums2.length;
            if (tot % 2 == 0) {
                int left = find(nums1, 0, nums2, 0, tot / 2);
                int right = find(nums1, 0, nums2, 0, tot / 2 + 1);
                return (left + right) / 2.0;
            } else {
                return find(nums1, 0, nums2, 0, tot / 2 + 1);
            }
        }

        // k means the kth.
        int find(int[] nums1, int i, int[] nums2, int j, int k) {
            if (nums1.length - i > nums2.length - j) {
                return find(nums2, j, nums1, i, k);
            }

            if (k == 1) {
                if (nums1.length == i)
                    return nums2[j];
                else
                    return Math.min(nums1[i], nums2[j]);
            }
            if (nums1.length == i)
                return nums2[j + k - 1];
            // k/2后一个
            int si = Math.min(nums1.length, i + k / 2), sj = j + k - k / 2;
            if (nums1[si - 1] > nums2[sj - 1]) {
                return find(nums1, i, nums2, sj, k - (sj - j));
            } else {
                return find(nums1, si, nums2, j, k - (si - i));
            }
        }
    }

    //TODO
    // [1,3] [2]  StackOverflowError. So add k == 1
    public double findMedianSortedArrays(int[] A1, int[] A2) {
        int m = A1.length, n = A2.length;

        int len = m + n;
        if (len % 2 == 1) {
            return (findKth(A1, 0, m - 1, A2, 0, n - 1, len / 2 + 1));
        }

        return (findKth(A1, 0, m - 1, A2, 0, n - 1, len / 2) + findKth(A1, 0, m - 1, A2, 0, n - 1, len / 2 + 1)) / 2.0;
    }

    // Always run simple test for recursion. ex: [1] [2]. Find median
    // kth smallest. Find by binary search. If the k / 2, A1[k / 2] is larger.
    // if mid search, if it is small, all the k / 2 cannot be the kth. So throw away. If the
    private int findKth(int[] A1, int l1, int r1, int[] A2, int l2, int r2, int k) {
        // System.out.println("l1 is " + l1 + " r1 is " + r1 + " l2 is " + l2 + " r2 is " + r2 + " k is "  + k);

        if (l1 > r1) {
            return A2[l2 + k - 1];
        }

        if (l2 > r2) {
            return A1[l1 + k - 1];
        }

        // when k is 1. need value. elase len1 = 0, len2 = 1
        if (k == 1) {
            return Math.min(A1[l1], A2[l2]);
        }

        // should be min.
        int len1 = Math.min(r1 - l1 + 1, k / 2);

        // java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1. [2,3,4] [1]
        // int len2 = k - len1;
        int len2 = Math.min(r2 - l2 + 1, k / 2);
        int idx1 = l1 + len1 - 1;
        int idx2 = l2 + len2 - 1;

        if (A1[idx1] > A2[idx2]) {
            return findKth(A1, l1, r1, A2, idx2 + 1, r2, k - len2);
        } else {
            return findKth(A1, idx1 + 1, r1, A2, l2, r2, k - len1);
        }
    }
}
