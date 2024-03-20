package queue_and_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/min-stack/description/">min-stack</a>
 */
public class MinStack {
    Deque<Integer> mainStack;
    //assistant stack to store min value
    Deque<Integer> minStack;
    public MinStack() {
        mainStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * for all operations
     * TC: O(1)
     * SC: O(n)  n is the capacity of stack
     */
    public void push(int val) {
        mainStack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
