package queue_and_stack;

import java.util.Arrays;

/**
 * create dequeue from circular array
 *
 * @see <a href=""></a>
 */
public class DequeueArray {
    private int[] nums;
    //the head of queue pointer
    private int front;
    //the size of queue
    private int queSize;

    public DequeueArray(int capacity) {
        nums = new int[capacity];
        front = queSize = 0;
    }

    //basic operations

    /**
     * get the size of queue
     * @return
     */
    public int size() {
        return queSize;
    }

    /**
     * get the capacity of queue
     * @return
     */
    public int capacity() {
        return nums.length;
    }

    /**
     * determine whether the queue is empty
     * @return
     */
    public boolean isEmpty() {
        return queSize == 0;
    }

    /**
     * A circular array is implemented by taking the remainder
     * @param i
     * @return
     */
    private int index(int i) {
        return (i + capacity()) % capacity();
    }


    /**
     * enqueue from the head
     * @param num
     */
    public void pushFirst(int num) {
        if (size() == capacity()) {
            System.out.println("queue is full");
            return;
        }
        front = index(front - 1);
        nums[front] = num;
        queSize++;
    }

    /**
     * enqueue from the tail
     * @param num
     */
    public void pushLast(int num) {
        if (size() == capacity()) {
            System.out.println("queue is full");
            return;
        }
        int rear = index(front + queSize);
        nums[rear] = num;
        queSize++;
    }

    /**
     * get value of the head of queue
     * @return
     */
    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    /**
     * get value of the tail of queue
     * @return
     */
    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int rear = index(front + queSize-1);
        return nums[rear];
    }

    /**
     * dequeue from the head
     * @return
     */
    public int popFirst() {
        int val = peekFirst();
        front = index(front + 1);
        queSize--;
        return val;
    }

    /**
     * dequeue from the tail
     * @return
     */
    public int popLast() {
        int val = peekLast();
        queSize--;
        return val;
    }

    /**
     * covert queue to array
     * @return
     */
    public int[] toArray() {
        int[] res = new int[queSize];
        for (int i = 0, j = front; i < queSize; i++, j++) {
            res[i] = nums[index(j)];
        }
        return nums;
    }


    public static void main(String[] args) {
        DequeueArray queue = new DequeueArray(10);
        queue.pushFirst(1);
        queue.pushFirst(2);
        queue.pushLast(3);
        System.out.println(Arrays.toString(queue.toArray()));
    }
}
