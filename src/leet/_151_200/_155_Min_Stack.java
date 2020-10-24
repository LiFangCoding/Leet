package leet._151_200;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class _155_Min_Stack {
    class MinStack {
        Stack<Integer> stk;
        Stack<Integer> minStk;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stk = new Stack<>();
            minStk = new Stack<>();
        }

        public void push(int x) {
            stk.push(x);
            if (minStk.isEmpty() || x <= minStk.peek()) {
                minStk.push(x);
            }
        }

        public void pop() {
            int x = stk.pop();
            if (minStk.peek() == x) {
                minStk.pop();
            }
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            return minStk.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
