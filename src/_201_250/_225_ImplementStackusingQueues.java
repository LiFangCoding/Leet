package _201_250;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class _225_ImplementStackusingQueues {
    /**
     * Stack: last in first out.
     * 1 2 3
     * Queue: first in first out
     * 3 4 5
     * 1 2
     */

    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public _225_ImplementStackusingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

    }

    /**
     * Get the top element.
     */
    public int top() {

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

    }
}
