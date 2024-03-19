package java.linked_list;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/reverse-linked-list/description/">reverse-linked-list</a>
 */
public class ReverseLinkedList {
    /**
     * iteration
     * TC: O(n) n is the capacity of Linked list
     * SC: O(1)
     * @param head
     * @return
     */
    public ListNode reverseLinkedList_iteration(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;

        while (cur != null) {
            //initial state: 1->2->3->null
            //store next node of current node, due to cur will change
            ListNode next = cur.next;
            //change: null<-1 2->3->null prev:null cur:1 next:2
            cur.next = prev;

            //store current node as the previous node for next cycle
            prev=cur;
            //update the head of linked list for next loop
            cur=next;

        }
        return prev;
    }


    /**
     * recursion
     * TC: O(n)  n is the capacity of Linked list
     * SC: O(n)  n is the capacity of Linked list
     * @param head
     * @return
     */
    public ListNode reverseLinkedList_recursion(ListNode head) {
        //from back to front
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList_recursion(head.next);
        //n1->n2->nk->nk+1<-nk+2<-nk+3<-nk+n
        //so nk+1.next=nk is equal to nk.next.next=nk
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
