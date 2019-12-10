package _51_100;

import java.util.Arrays;

public class _80_Remove_Duplicates_from_Sorted_Array2 {
    public static void main(String[] args) {
        _80_Remove_Duplicates_from_Sorted_Array2 test = new _80_Remove_Duplicates_from_Sorted_Array2();
        int[] A = new int[]{1, 1, 1, 2, 2, 3};

        test.removeDuplicates(A);
        System.out.println(Arrays.toString(A));
    }

    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        if (A.length <= 2) {
            return A.length;
        }

        int last = 1;
        /**
         * be careful here. Because the index will be updated also.
         * !!! for each element iteration, compare with new array, not the old array value.
         * Because old array value can be override by new array.
         */
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[last] && A[i] == A[last - 1]) {
                continue;
            }
            last++;
            A[last] = A[i];
        }

        return last + 1;
    }
}
