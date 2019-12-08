package _51_100;

public class _73_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHasZero = false;

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            boolean hasZero = false;
            /**
             * check all the columns is 0 for one row.
             * Mark it on first row
             */
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    hasZero = true;
                }
            }

            /**
             * set row value to 0
             */
            if (hasZero) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;
            }
        }

        /**
         * Clear all columns which is 0
         */
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
