package java.linked_list;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/delete-node-in-a-linked-list/description">delete-node-in-a-linked-list</a>
 */
public class deleteNodeInLinkedList {
    /**
     * TC: O(1)
     * SC: O(1)
     * @param node
     */
    public void deleteNode(ListNode node) {
        //No head node is provided and node is not the last node
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
