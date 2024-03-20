package java.queue_and_stack;

/**
 * create deque base on linked list
 *
 */
public class DequeLinkedList {
    //Doubly linked list node
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            prev = next = null;
        }
    }

    //the head and tail node of queue
    private ListNode front, rear;
   //the size of queue
    private int queSize;

    public DequeLinkedList() {
        front = rear = null;
        queSize = 0;
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
     * determines whether the queue is empty
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * enqueue
     * @param num
     * @param isFront
     */
    public void push(int num, boolean isFront) {
        ListNode node = new ListNode(num);
        if (isEmpty()) {
            front = rear = node;
        } else if (isFront) {
            front.prev = node;
            node.next = front;
            front = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        queSize++;
    }

    /**
     * enqueue from the head
     * @param num
     */
    public void pushFirst(int num) {
        push(num, true);
    }

    /**
     * enqueue from the tail
     * @param num
     */
    public void pushlast(int num) {
        push(num, false);
    }


    /**
     * dequeue
     * @param isFront
     * @return
     */
    public int pop(boolean isFront) {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        int val;
        if (isFront) {
            val = front.val;
            ListNode fNext = front.next;
            if (fNext != null) {
                fNext.prev = null;
                front.next = null;
            }
            front = fNext;
        } else {
            val = rear.val;
            ListNode rPrev = rear.prev;
            if (rPrev != null) {
                rPrev.next = null;
                rear.prev = null;
            }
            rear = rPrev;
        }
        queSize--;
        return val;
    }

    /**
     * dequeue from the head
     * @return
     */
    public int popFirst() {
        return pop(true);
    }

    /**
     * dequeue from the tail
     * @return
     */
    public int popLast() {
        return pop(false);
    }


    /**
     * get the value of head of queue
     * @return
     */
    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    /**
     * get the value of tail of queue
     * @return
     */
    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return rear.val;
    }

    /**
     * covert queue to array
     * @return
     */
    public int[] toArray() {
        int[] res = new int[size()];
        ListNode head = front;
        for (int i = 0; i < res.length-1; i++) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
