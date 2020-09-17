package leet._51_100;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class _85_Maximal_Rectangle {
    //TODO

    /**
     * T = m * n
     * 将 Largest Rectangle in Histogram 问题扩展到二维。
     * 一行一行考虑，类比 Largest Rectangle in Histogram，一行内所有柱形条的高度 heights 就是当前 (i, j) 位置能往上延伸的最大高度。
     * 直接套用 Largest Rectangle in Histogram 的单调栈算法即可。
     * 时间复杂度
     * 枚举每一行的时间复杂度是 O(n)，行内单调栈的时间复杂度是 O(m)，故总时间复杂度为 (nm)。
     * 空间复杂度
     * 需要额外 O(m) 的空间存放高度和用于单调栈。
     * https://www.acwing.com/solution/content/141/
     */
    class Sol_short {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int rows = matrix.length, cols = matrix[0].length;
            int ans = 0;

            int[] heights = new int[cols + 1];
            heights[cols] = -1;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == '0') {
                        heights[j] = 0;
                    } else {
                        heights[j]++;
                    }
                }

                Stack<Integer> stack = new Stack<>();
                // need to unitl cols to pop out if all increasing
                for (int col = 0; col <= cols; col++) {
                    while (!stack.isEmpty() && heights[col] < heights[stack.peek()]) {
                        int cur = stack.pop();
                        if (stack.isEmpty()) {
                            ans = Math.max(ans, heights[cur] * col);
                        } else {
                            ans = Math.max(ans, heights[cur] * (col - stack.peek() - 1));
                        }
                    }
                    // heights[col] > stack peek. So it is increasing stack
                    stack.push(col);
                }
            }

            return ans;
        }
    }

    class Sol_longer {
        /**
         * @param
         * @return
         */
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int[] heights = new int[matrix[0].length];
            int maxArea = 0;
            for (int row = 0; row < matrix.length; row++) {
                //遍历每一列，更新高度
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                //调用上一题的解法，更新函数
                maxArea = Math.max(maxArea, largestRectangleArea(heights));
            }
            return maxArea;
        }

        public int largestRectangleArea(int[] heights) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            int p = 0;
            while (p < heights.length) {
                //栈空入栈
                if (stack.isEmpty()) {
                    stack.push(p);
                    p++;
                } else {
                    int top = stack.peek();
                    //当前高度大于栈顶，入栈
                    if (heights[p] >= heights[top]) {
                        stack.push(p);
                        p++;
                    } else {
                        //保存栈顶高度
                        int height = heights[stack.pop()];
                        //左边第一个小于当前柱子的下标
                        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                        //右边第一个小于当前柱子的下标
                        int RightLessMin = p;
                        //计算面积
                        int area = (RightLessMin - leftLessMin - 1) * height;
                        maxArea = Math.max(area, maxArea);
                    }
                }
            }
            while (!stack.isEmpty()) {
                //保存栈顶高度
                int height = heights[stack.pop()];
                //左边第一个小于当前柱子的下标
                int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                //右边没有小于当前高度的柱子，所以赋值为数组的长度便于计算
                int RightLessMin = heights.length;
                int area = (RightLessMin - leftLessMin - 1) * height;
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }
    }
    // 作者：windliang
    // 链接：https://leetcode-cn.com/problems/maximal-rectangle/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-8/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
