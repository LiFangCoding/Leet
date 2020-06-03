package _51_100;

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
