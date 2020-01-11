package _151_200;

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
    Stack<Integer> vals;
    Stack<Integer> mins;

    public _155_Min_Stack() {
        vals = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        if (mins.isEmpty()) {
            mins.push(x);
        } else if (x <= mins.peek()) {
            mins.push(x);
        }

        vals.push(x);
    }

    public void pop() {
        /**
         * !!! check isEmpty or not
         */
        if (vals.isEmpty() || mins.isEmpty()) {
            return;
        }

        if (mins.peek().equals(vals.peek())) {
            mins.pop();
            vals.pop();
        } else {
            vals.pop();
        }
    }

    public int top() {
        if (vals.isEmpty()) {
            return -1;
        }
        return vals.peek();
    }

    public int getMin() {
        if (mins.isEmpty()) {
            return -1;
        }
        return mins.peek();
    }
}
