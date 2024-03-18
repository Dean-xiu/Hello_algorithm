package java.linked_list;
//linked list node definition
public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    //Basic operations

    /**
     * insert ListNode p after ListNode n0
     * @param n0
     * @param p
     */
    public void insert(ListNode n0, ListNode p) {
        //initial state:n0->n1
        ListNode n1 = n0.next;
        //change: n0->p n1
        n0.next=p;
        //final state: n0->p->n1
        p.next = n1;
    }

    /**
     * delete the first node after n0
     * @param n0
     */
    public void delete(ListNode n0) {
        //initial state: n0->p->n1
        if (n0.next == null)
            return;
        ListNode p = n0.next;
        //final state: n0->n1
        n0.next = p.next;
    }

    /**
     * access the node with the index in the linked list
     * @param head
     * @param index
     * @return
     */
    public ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        return head;
    }

    /**
     * find the node whose value is equal to target and return the index of the node
     * @param head
     * @param target
     * @return
     */
    public int find(ListNode head, int target) {
        int index=0;
        while (head != null) {
            if(head.val==target)
                return index;
            head = head.next;
            index++;
        }
        //fail to find
        return -1;
    }

}
