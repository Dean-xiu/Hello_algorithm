package java.queue_and_stack;

import java.linked_list.ListNode;

/**
 * Create stack based on linked list
 *
 */
public class StackLinkedList {
    // head node as the top of stack
    private ListNode stackPeek;
    // the size of stack
    private int stkSize;


    public StackLinkedList() {
        stackPeek = null;
        stkSize = 0;
    }

    //basic operations
    /**
     * get the size of stack
     * @return
     */
    public int size(){
        return stkSize;
    }

    /**
     * determines whether the stack is empty
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
        ListNode node = new ListNode(num);
        //insert from head of linked list
        node.next=stackPeek;
        stackPeek=node;
        stkSize++;
    }

    /**
     * access the top of stack
     * @return
     */
    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return stackPeek.val;
    }

    /**
     * popped off the stack
     * @return
     */
    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        stkSize--;
        return num;
    }

    /**
     * convert stack to array
     * @return
     */
    public int[] toArray(){
        int[] res = new int[size()];
        ListNode head = stackPeek;

        //the top of stack is the tail of array, so flashback traversal
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
