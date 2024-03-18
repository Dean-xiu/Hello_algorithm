package java.linked_list;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/partition-list/description/">partition-list</a>
 */
public class partitionLinkedList {
    /**
     * double pointer
     * TC: O(n)  n is the capacity of Linked list
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        //Dummy node point to the head of small list and large list respectively
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);

        //double pointer is used for movement
        ListNode small = smallHead;
        ListNode large = largeHead;

        //assemble small and large list
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        //joint small and large list to result
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
