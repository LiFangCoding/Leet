package _51_100;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _73_Set_Matrix_Zeroes {
    //TODO

    /**
     * T = mn
     * 我们只需统计出矩阵中每一行或者每一列是否有0，然后把含有0的行或者列都置成0即可。
     * <p>
     * 用两个变量记录第一行和第一列是否有0。
     * 遍历整个矩阵，用矩阵的第一行和第一列记录对应的行和列是否有0。
     * 把含有0的行和列都置成0。
     * 时间复杂度分析：矩阵中每个元素只遍历常数次数，所以时间复杂度是 (nm)。
     * 空间复杂度分析：只用了两个额外的变量记录第一行和第一列是否含有0，所以额外的空间复杂度是 (1)，满足原地算法的要求
     * https://www.acwing.com/solution/content/158/
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRow0 = false;
        boolean firstCol0 = false;

        // check first row has 0 or not
        for (int r = 0; r < rows; r++) {
            // first col as 0
            if (matrix[r][0] == 0) {
                firstCol0 = true;
                break;
            }
        }

        // check first col has 0 or not
        for (int c = 0; c < cols; c++) {
            // first row
            if (matrix[0][c] == 0) {
                firstRow0 = true;
                break;
            }
        }

        // check all other parts has 0 or not, and set into the first row and col
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // set all rows after 0 to 0
        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < cols; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // set all cols after 0 to 0
        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (firstRow0) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstCol0) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}