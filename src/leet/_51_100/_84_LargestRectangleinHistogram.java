package leet._51_100;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * <p>
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class _84_LargestRectangleinHistogram {
    //TODO

    /**
     * T = n
     * S = n
     * mono stack
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
     * mono stack can always use dp to find left max and right max and so on
     * <p>
     * 此题的本质是找到每个柱形条左边和右边最近的比自己低的矩形条，然后用宽度乘上当前柱形条的高度作为备选答案。
     * 解决此类问题的经典做法是单调栈，维护一个单调递增的栈，如果当前柱形条 i 的高度比栈顶要低，则栈顶元素 cur 出栈。出栈后，cur 右边第一个比它低的柱形条就是 i，左边第一个比它低的柱形条是当前栈中的 top。不断出栈直到栈为空或者柱形条 i 不再比 top 低。
     * 满足 2 之后，当前矩形条 i 进栈。
     * https://www.acwing.com/solution/content/140/
     */

    class Sol_new_acwing {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] A = new int[heights.length + 1];
            for (int i = 0; i < n; i++) {
                A[i] = heights[i];
            }
            A[n] = -1;
            heights = A;
            // 为了算法书写方便，在数组末尾添加高度 -1
            // 这会使得栈中所有数字在最后出栈。
            int ans = 0;

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= n; i++) {
                while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                    int cur = stack.pop();

                    if (stack.isEmpty()) {
                        ans = Math.max(ans, heights[cur] * i);
                    } else {
                        ans = Math.max(ans, heights[cur] * (i - stack.peek() - 1));
                    }
                }
                stack.push(i);
            }

            return ans;
        }
    }

    class Sol_old {
        public int largestRectangleArea(int[] heights) {
            int ans = 0;
            // increasing stack
            Stack<Integer> stack = new Stack<>();

            int[] A = new int[heights.length + 2];
            A[0] = 0;
            for (int i = 1; i < A.length - 1; i++) {
                A[i] = heights[i - 1];
            }
            A[A.length - 1] = 0;

            // [2,1,2]
            // expected is 3. Actual is 2 if the left = cur
            for (int i = 0; i < A.length; i++) {
                // to find the stack top element area. Can find left small and right small idx.
                while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                    int cur = stack.pop();
                    int left = stack.peek() + 1;
                    int right = i - 1;
                    // cur高度面积
                    ans = Math.max(ans, (right - left + 1) * A[cur]);
                }

                stack.push(i);
            }

            return ans;
        }
    }
}
