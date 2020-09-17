package leet._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class _54_Spiral_Matrix {
    //TODO
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return ans;
        }

        int rows = matrix.length, cols = matrix[0].length;

        int upRow = 0, downRow = rows - 1;
        int leftCol = 0, rightCol = cols - 1;

        while (true) {
            // add first row
            for (int col = leftCol; col <= rightCol; col++) {
                ans.add(matrix[upRow][col]);
            }
            upRow++;
            if (upRow > downRow) {
                break;
            }

            for (int row = upRow; row <= downRow; row++) {
                ans.add(matrix[row][rightCol]);
            }
            rightCol--;
            if (rightCol < leftCol) {
                break;
            }

            for (int col = rightCol; col >= leftCol; col--) {
                ans.add(matrix[downRow][col]);
            }
            downRow--;
            if (downRow < upRow) {
                break;
            }

            for (int row = downRow; row >= upRow; row--) {
                ans.add(matrix[row][leftCol]);
            }
            leftCol++;
            if (leftCol > rightCol) {
                break;
            }
        }

        return ans;
    }
}
