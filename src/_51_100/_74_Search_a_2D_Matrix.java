package _51_100;

public class _74_Search_a_2D_Matrix {
    /**
     * matrix
     * 0, 1, 2
     * 3, 4, 5
     * m = 2
     * n = 3
     *
     * @param M
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] M, int target) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return false;
        }

        int m = M.length;
        int n = M[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            /**
             * !!! here is n. Not m.
             */
            int row = mid / n;
            int col = mid % n;

            if (M[row][col] == target) {
                return true;
            } else if (M[row][col] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (M[end / n][end % n] == target) {
            return true;
        }

        return M[start / n][start % n] == target;
    }
}
