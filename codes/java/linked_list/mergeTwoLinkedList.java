package java.linked_list;

/**
 * Question link
 * @see <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">merge-two-sorted-lists</a>
 */
public class mergeTwoLinkedList {
    //递归
    public ListNode mergeTwoLists_recursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }else{
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists_recursion(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists_recursion(list1, list2.next);
                return list2;
            }
        }
    }

    //迭代
    public ListNode mergeTwoLists_iteration(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        //合并list1或list2剩余部分
        prev.next = list1 == null ? list2 : list1;
        
        return prehead.next;
    }
}
