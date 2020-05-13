package _51_100;

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
    /**
     * mono stack
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
     * mono stack can always use dp to find left max and right max and so on
     */
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
