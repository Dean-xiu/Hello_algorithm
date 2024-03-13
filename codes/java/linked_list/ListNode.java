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
}
