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
    /**
     * initialize your data structure here.
     */
    Stack<Integer> valStack;
    Stack<Integer> minStack;

    public _155_Min_Stack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        valStack.push(x);

        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        /**
         * !!! check isEmpty or not
         */
        if (!valStack.isEmpty()) {
            int val = valStack.pop();
            if (minStack.peek() == val) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (valStack.isEmpty()) {
            return -1;
        }
        return valStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        Integer.parseInt("123");
        return minStack.peek();
    }
}
