package java.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/description">copy-list-with-random-pointer</a>
 */
public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * Hash table
     * TC: O(n)  n is the capacity of Linked list, iterate through the list twice
     * SC: O(n)  n is the size of map
     * @param head
     * @return
     */
    public Node copyRandomList_hash(Node head) {
        if (head == null) {
            return null;
        }

        Node cur=head;
        Map<Node, Node> hashTable = new HashMap<>();
        //In the first round, the hash table is populated
        while (cur != null) {
            hashTable.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        //reset cur
        cur = head;

        //In the second round, build the random and next points of the new list
        while (cur != null) {
            hashTable.get(cur).next = hashTable.get(cur.next);
            hashTable.get(cur).random = hashTable.get(cur.random);
            cur=cur.next;
        }
        return hashTable.get(head);
    }


    /**
     * splice and split
     * TC: O(n)  n is the capacity of linked list, iterate through the list three times
     * SC: O(1)
     * @param head
     * @return
     */
    public Node copyRandomList_spliceAndSplit(Node head) {
        if(head==null){
            return null;
        }

        //The first iteration replicates the nodes
        Node cur=head;
        while (cur != null) {
            Node curCopy = new Node(cur.val);
            curCopy.next=cur.next;
            cur.next=curCopy;
            cur=curCopy.next;
        }

        //reset cur
        cur = head;

        //The second iteration builds the random points of the new list
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //reset cur
        cur=head.next;

        //The third iteration split two linked list
        Node pre=head;
        //store the head of new linked list and the cur is used to move
        Node res = cur;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}
