package leet._201_250;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 */
public class _223_RectangleArea {
    /**
     * No need to consider overflow. More clear.
     */
    public int computeArea_readable(int A, int B, int C, int D, int E, int F, int G, int H) {
        /**
         * !!! Integer overflow. for - .
         * -1500000001
         * 0
         * -1500000000
         * 1
         * 1500000000
         * 0
         * 1500000001
         * 1
         *
         * -1294967294
         */
        int area1 = (D - B) * (C - A);
        int area2 = (H - F) * (G - E);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int down = Math.max(B, F);
        int up = Math.min(D, H);

        if (left >= right || down >= up) {
            return area1 + area2;
        }
        return area1 - (right - left) * (up - down) + area2;
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        /**
         * !!! Integer overflow. for - .
         * -1500000001
         * 0
         * -1500000000
         * 1
         * 1500000000
         * 0
         * 1500000001
         * 1
         *
         * -1294967294
         *
         * because the Math.min(C, G) - Math.max(A, E) can be negative - negative.
         */
        long x = Math.max(0L, 0L + Math.min(C, G) - Math.max(A, E));
        long y = Math.max(0L, 0L + Math.min(D, H) - Math.max(B, F));
        return (int) ((C - A) * (D - B) - x * y + (G - E) * (H - F));
    }
}
