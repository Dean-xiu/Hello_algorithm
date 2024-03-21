package queue_and_stack;

import java.util.Stack;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/">implement-queue-using-stacks</a>
 */
public class QueueUsingStack {
    //used to store elements that need to be enqueued
    Stack<Integer> stack ;
    //used to assist elements that need to be dequeued
    Stack<Integer> reverseOrderStack ;

    public QueueUsingStack() {
        stack = new Stack<>();
        reverseOrderStack = new Stack<>();
    }

    /**
     * put on the stack
     * TC: O(1)
     * SC: O(n)  n is the capacity of queue
     * @param x
     */
    public void push(int x) {
        stack.push(x);
    }

    /**
     * pop off the reverse order stack
     * TC: O(1)  amortize the time complexity
     * SC: O(n)
     * @return
     */
    public int pop() {
        int peek = peek();
        reverseOrderStack.pop();
        return peek;
    }

    /**
     * get the value from the top
     * TC: O(1)  amortize the time complexity
     * SC: O(n)
     * @return
     */
    public int peek() {
        if (!reverseOrderStack.isEmpty()) {
            return reverseOrderStack.peek();
        } else if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                reverseOrderStack.push(stack.pop());
            }
            return reverseOrderStack.peek();
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * determine whether queue is empty
     * TC: O(1)
     * SC: O(n)
     * @return
     */
    public boolean empty() {
        return stack.isEmpty() && reverseOrderStack.isEmpty();
    }
}
