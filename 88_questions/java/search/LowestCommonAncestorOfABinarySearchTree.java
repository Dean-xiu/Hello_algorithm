package search;

import javax.swing.*;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">lowest-common-ancestor-of-a-binary-search-tree</a>
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * recursion
     * TC: O(n)
     * SC: O(n)  use system stack space
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_Recursion(TreeNode root, TreeNode p, TreeNode q) {
        //due to bst, so if subtree.value greater than root.val that means subtree is on the right tree of root
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor_Recursion(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor_Recursion(root.left, p, q);
        }
        return root;
    }


    /**
     * Iteration
     * TC: O(n)
     * SC: O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_Iteration(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            }else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }else{
                break;
            }
        }
        return root;
    }

}
