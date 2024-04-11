package double_pointer;

import linked_list.ListNode;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/">linked-list-cycle-ii</a>
 */
public class LinkedListCycle {
    /**
     * double pointer
     * TC: O(n)  n is the number of linked list
     * SC: O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //the first encounter indicates the existence of a loop
        ListNode slow = head, fast = head;
        while (true) {
            if(fast==null || fast.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                break;
        }

        //the second meeting point is the ring entrance
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
