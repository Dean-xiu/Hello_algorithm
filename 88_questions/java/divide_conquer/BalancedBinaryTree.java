package divide_conquer;

import search.TreeNode;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/balanced-binary-tree/description/">balanced-binary-tree</a>
 */
public class BalancedBinaryTree {
    /**
     * Post order traversal + pruning
     * TC: O(n)  n is the number of Tree node
     * SC: O(n)
     * @param root
     * @return
     */
    public boolean isBalanced_post(TreeNode root) {
        return depth_post(root) == -1 ? false : true;
    }

    private int depth_post(TreeNode root) {
        if(root==null) return 0;
        int left = depth_post(root.left);
        //pruning
        if(left==-1) return -1;
        int right = depth_post(root.right);
        if(right==-1) return -1;

        //compute depth
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    /**
     * First order traversal + compute depth
     * TC: O(nlogn)  n is the number of Tree node
     * SC: O(n)
     */
    public boolean isBalanced_First(TreeNode root) {
        if(root==null) return true;

        return Math.abs(depth(root.left) - depth(root.right)) <= 1
                && isBalanced_First(root.left)
                && isBalanced_First(root.right);
    }

    private int depth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

}
