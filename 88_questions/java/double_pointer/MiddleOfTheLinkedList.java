package double_pointer;

import linked_list.ListNode;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/middle-of-the-linked-list/description/">middle-of-the-linked-list</a>
 */
public class MiddleOfTheLinkedList {
    /**
     * Array
     * TC: O(n)  n is the number of nodes
     * SC: O(n)  n is the number of nodes
     * @param head
     * @return
     */
    public ListNode middleNode_array(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int i = 0;

        while (head != null) {
            nodes[i++] = head;
            head = head.next;
        }

        return nodes[i / 2];
    }


    /**
     * Single pointer
     * TC: O(n)  n is the number of nodes
     * SC: O(1)
     * @param head
     * @return
     */
    public ListNode middleNode_singlePointer(ListNode head){
        int n = 0;
        ListNode cur = head;

        //the first pass to count the number of nodes
        while(cur!=null){
            n++;
            cur = cur.next;
        }

        //the second pass to find middle node
        cur=head;
        int k=0;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }


    /**
     * Fast and slow pointer
     * TC: O(n)  n is the number of nodes
     * SC: O(1)
     * @param head
     * @return
     */
    public ListNode middleNode_fastAndSlowPointer(ListNode head){
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
