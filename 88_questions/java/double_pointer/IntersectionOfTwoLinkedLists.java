package double_pointer;

import linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/">intersection-of-two-linked-lists</a>
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * Hash Table
     * TC: O(m+n)  m,n is the size of Linked List A and B
     * SC: O(m)  m is the size of the linked list A
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_hashTable(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    /**
     * Double Pointer
     * TC: O(m+n)  m,n is the size of Linked list A and B
     * SC: O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_doublePointer(ListNode headA, ListNode headB){
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pA.next;
        }
        return pA;
    }
}
