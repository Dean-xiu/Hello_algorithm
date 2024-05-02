package search;

import java.util.Stack;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/description/">convert-binary-search-tree-to-sorted-doubly-linked-list</a>
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    /**
     * recursion_inorder traversal
     * TC: O(n)
     * SC: O(n)
     */
    Node pre,head;

    private void dfs(Node cur) {
        if(cur==null) return;
        dfs(cur.left);
        //pre==null only execute once
        if(pre==null) head=cur;
        else pre.right=cur;
        cur.left=pre;
        //update pre
        pre=cur;
        dfs(cur.right);
    }
    public Node treeToDoublyList_Dfs(Node root) {
        if(root==null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }


    /**
     * Stack_inorder traversal
     * TC: O(n)
     * SC: O(n)
     */
    public Node treeToDoublyList_Stack(Node root) {
        if(root==null) return null;
        Node pre=null,head=null;
        Stack<Node> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre==null) head = root;
            else pre.right=root;
            root.left=pre;
            //update pre
            pre=root;

            root = root.right;
        }
        head.left=pre;
        pre.right = head;
        return head;
    }
}
