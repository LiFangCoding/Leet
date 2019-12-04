package _51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class _54_Spiral_Matrix {
  public List<Integer> spiralOrder(int[][] M) {
    int rows = M.length;
    int cols = M[0].length;

    int rowStart = 0;
    int colStart = 0;
    int rowEnd = rows - rowStart - 1;
    int colEnd = cols - colStart - 1;

    List<Integer> res = new ArrayList<>();


    while (rowStart <= rowEnd && colStart <= colEnd) {
      addMatrix(M, rowStart++, rowEnd--, colStart++, colEnd--, res);
    }

    return res;
  }

  /**
   * four coner
   * [left, top]
   * [right, top]
   * [right, bottom]
   * [left, bottom]
   *
   * Input:
   * [
   *   [1, 2, 3, 4],
   *   [5, 6, 7, 8],
   *   [9,10,11,12]
   * ]
   *
   * We just need left, top
   */
  private void addMatrix(int[][] M, int rowStart, int rowEnd,int colStart, int colEnd, List<Integer> res) {
    // up row
    for (int i = colStart; i <= colEnd; i++) {
      res.add(M[rowStart][i]);
    }

    // right col
    for (int i = rowStart + 1; i <= rowEnd; i++) {
      res.add(M[i][colEnd]);
    }

    // bottom row
    for (int i = colEnd - 1; i >= colStart; i--) {
      res.add(M[rowEnd][i]);
    }

    // left col
    for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
      res.add(M[i][colStart]);
    }
  }

  public static void main(String[] args) {
    int[][] M = new int[][] {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9,10,11,12}
    };

    _54_Spiral_Matrix test = new _54_Spiral_Matrix();
    System.out.println(test.spiralOrder(M));
  }
}
