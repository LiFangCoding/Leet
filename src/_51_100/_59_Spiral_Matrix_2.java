package _51_100;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class _59_Spiral_Matrix_2 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] steps = {n, n - 1, n - 1, n - 2};

        int idx = 0;
        int num = 1;
        int x = 0, y = -1;

        while (true) {
            // If no steps more, just return.
            if (steps[idx] <= 0) break;

            // run the idx dir all steps
            for (int i = 0; i < steps[idx]; i++) {
                x += dirs[idx][0];
                y += dirs[idx][1];
                matrix[x][y] = num++;
            }

            // update the dir idx
            steps[idx] -= 2;
            idx++;
            idx = idx % 4;
        }

        return matrix;
    }
}