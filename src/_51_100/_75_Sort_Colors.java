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

        int len = A.length;
        int left = 0;
        int right = len - 1;

        /**
         * !!! pay attention.
         * before left are all the 0s. Behind right are all the 1s.
         * Interate all the elements, if meet 0, swap it to 0s,
         * the swapped back value can be 0 ({0}) or 1. No need to care since no 2.
         * If meet 2, swap it to 2s. Care swapped value. Since it can be 0,1,2
         * Then all are well sorted.
         */
        for (int i = 0; i <= right; ) {
            if (A[i] == 0) {
                /**
                 * !! if not i++, since swap can be 0. left will ++.
                 */
                swap(A, i, left++);
            } else if (A[i] == 2) {
                swap(A, i, right--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
