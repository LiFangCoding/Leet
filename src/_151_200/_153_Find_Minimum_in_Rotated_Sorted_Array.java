package _151_200;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class _153_Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        _153_Find_Minimum_in_Rotated_Sorted_Array test = new _153_Find_Minimum_in_Rotated_Sorted_Array();

        int[] A = new int[]{3, 4, 5, 1, 2};

        System.out.println(test.findMin(A));
    }

    public int findMin(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;

        /**
         * !!! Important:
         * termination is start + 1 < end.
         */
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            /**
             * from start to mid is in order
             * Sometimes index 0 can be the smallest
             */
            if (A[mid] > A[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return A[start] < A[end] ? A[start] : A[end];
    }
}
