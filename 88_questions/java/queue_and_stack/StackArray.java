package queue_and_stack;

import java.util.ArrayList;

/**
 * Create stack base on array
 */
public class StackArray {
    //use dynamic array, don't need to scale manually
    private ArrayList<Integer> stack;

    public StackArray() {
        stack = new ArrayList<>();
    }

    //basic operations

    /**
     * get the size of stack
     * @return
     */
    public int size() {
        return stack.size();
    }

    /**
     * determine whether the stack is empty
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * put on the stack
     * @param num
     */
    public void push(int num) {
        stack.add(num);
    }

    /**
     * get the top of stack
     * @return
     */
    public int peek() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.get(size() - 1);
    }

    /**
     * popped off the stack
     * @return
     */
    public int pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.remove(size() - 1);
    }

    /**
     * convert stack to array
     * @return
     */
    public Object[] toArray() {
        return stack.toArray();
    }
}
