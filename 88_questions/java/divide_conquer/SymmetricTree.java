package divide_conquer;

import search.TreeNode;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/symmetric-tree/description/">symmetric-tree</a>
 */
public class SymmetricTree {
    /**
     * divide and conquer
     * TC: O(n)  n is the number of Tree node
     * SC: O(n)
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
