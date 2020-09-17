package leet;

import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class _739_Daily_temperatures {
    public int[] dailyTemperatures(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int[] ans = new int[A.length];
        // stack stores the index. It should be decreasing stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                int topIdx = stack.pop();
                ans[topIdx] = i - topIdx;
            }
            stack.push(i);
        }

        return ans;
    }
}
