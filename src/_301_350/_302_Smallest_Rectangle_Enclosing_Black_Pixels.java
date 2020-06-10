package _301_350;

import java.util.LinkedList;
import java.util.Queue;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * "0010",
 * "0110",
 * "0100"
 * ]
 * and x = 0, y = 2
 * <p>
 * Output: 6
 */
public class _302_Smallest_Rectangle_Enclosing_Black_Pixels {
    /**
     * 1ms
     * T = O(MlogN+NlogM)（最坏情况）
     * 题解： 根据题意，在列中需要找出第一个'1'出现的最左侧坐标和最右侧坐标，在行中需要找出第一个'1'出现的最上面坐标和最下面坐标。故采用二分的方法在区间查找即可。最后返回(right - left + 1) * (bottom - top + 1)即可。
     * https://www.jiuzhang.com/solution/smallest-rectangle-enclosing-black-pixels/
     */
    class Sol_Binary_search_boundary {
        public int minArea(char[][] image, int x, int y) {
            if (image == null || image.length == 0 || image[0].length == 0) {
                return 0;
            }

            int n = image.length;
            int m = image[0].length;

            int left = findLeft(image, 0, y);
            int right = findRight(image, y, m - 1);
            int top = findTop(image, 0, x);
            int bottom = findBottom(image, x, n - 1);

            return (right - left + 1) * (bottom - top + 1);
        }

        private int findLeft(char[][] image, int start, int end) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (isEmptyColumn(image, mid)) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (isEmptyColumn(image, start)) {
                return end;
            }

            return start;
        }

        private int findRight(char[][] image, int start, int end) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (isEmptyColumn(image, mid)) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (isEmptyColumn(image, end)) {
                return start;
            }

            return end;
        }

        private int findTop(char[][] image, int start, int end) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (isEmptyRow(image, mid)) {
                    start = mid;
                } else {
                    end = mid;
                }
            }

            if (isEmptyRow(image, start)) {
                return end;
            }

            return start;
        }

        private int findBottom(char[][] image, int start, int end) {
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (isEmptyRow(image, mid)) {
                    end = mid;
                } else {
                    start = mid;
                }
            }

            if (isEmptyRow(image, end)) {
                return start;
            }

            return end;
        }

        private boolean isEmptyColumn(char[][] image, int col) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][col] == '1') {
                    return false;
                }
            }
            return true;
        }

        private boolean isEmptyRow(char[][] image, int row) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[row][j] == '1') {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 12ms
     * T= M * N
     * since dfs can cause stack overflow
     */
    class Sol_BFS {
        public int minArea(char[][] image, int x, int y) {
            if (image == null || image.length == 0 || image[0].length == 0) {
                return 0;
            }
            int n = image.length;
            int m = image[0].length;

            boolean[][] visited = new boolean[n][m];

            Queue<Integer> queueX = new LinkedList<Integer>();
            Queue<Integer> queueY = new LinkedList<Integer>();
            queueX.offer(x);
            queueY.offer(y);
            visited[x][y] = true;

            int maxX = x;
            int maxY = y;
            int minX = x;
            int minY = y;

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            while (!queueX.isEmpty()) {
                int i = queueX.poll();
                int j = queueY.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m
                            && !visited[nx][ny]
                            && image[nx][ny] == '1') {
                        visited[nx][ny] = true;
                        queueX.offer(nx);
                        queueY.offer(ny);

                        maxX = Math.max(maxX, nx);
                        minX = Math.min(minX, nx);
                        maxY = Math.max(maxY, ny);
                        minY = Math.min(minY, ny);
                    }
                }
            }

            return (maxX - minX + 1) * (maxY - minY + 1);
        }
    }
}
