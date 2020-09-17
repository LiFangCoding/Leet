package leet._1_50;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * Example 2:
 * <p>
 * Given input matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class _48_Rotate_Image {
    //TODO

    /**
     * T = O(n ^ 2)
     * S = O(1)
     *
     * @param mt
     */
    public void rotate(int[][] mt) {
        int n = mt.length;

        /**
         * transpose matrix
         * j = i ~ n - 1
         */
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = mt[i][j];
                mt[i][j] = mt[j][i];
                mt[j][i] = tmp;
            }
        }

        /**
         * reverse each row
         * j = 0 ~ n / 2 - 1
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = mt[i][j];
                mt[i][j] = mt[i][n - j - 1];
                mt[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        _48_Rotate_Image test = new _48_Rotate_Image();
        test.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
