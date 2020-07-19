package _51_100;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _74_Search_a_2D_Matrix {
  /**
   * matrix
   * 0, 1, 2
   * 3, 4, 5
   * m = 2
   * n = 3
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return false;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int n = rows * cols;

    int l = 0, r = n - 1;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;
      int row = mid / cols;
      int col = mid % cols;

      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        l = mid;
      } else {
        r = mid;
      }
    }

    return matrix[l / cols][l % cols] == target || matrix[r / cols][r % cols] == target;
  }
}
