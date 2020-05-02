package _51_100;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class _75_Sort_Colors {
    public static void main(String[] args) {
        _75_Sort_Colors test = new _75_Sort_Colors();
        int[] A = {2, 0, 2, 1, 1, 0};
        test.sortColors(A);
        System.out.println(Arrays.toString(A));
    }

    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        // the r's right all 2. l's left all 0. l can be 0 or 1.  r can be 0,1,2.
        int l = 0, r = A.length - 1;
        // sort in the range of l and r
        for (int i = 0; i >= l && i <= r; ) {
            if (A[i] == 2) {
                swap(A, i, r--);
            } else if (A[i] == 0) {
                swap(A, i++, l++);
            } else if (A[i] == 1) {
                i++;
            }
        }

        /**
         * !!! pay attention.
         * before left are all the 0s. Behind right are all the 1s.
         * Interate all the elements, if meet 0, swap it to 0s,
         * the swapped back value can be 0 ({0}) or 1. No need to care since no 2.
         * If meet 2, swap it to 2s. Care swapped value. Since it can be 0,1,2
         * Then all are well sorted.
         */
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
