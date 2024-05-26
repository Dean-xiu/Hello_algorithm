package divide_conquer;

import search.TreeNode;

import java.util.Stack;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/invert-binary-tree/description/">invert-binary-tree</a>
 */
public class InvertBinaryTree {
    /**
     * Divide and Conquer
     * TC: O(n)  n is the number of tree nodes
     * SC: O(n)  Recursion requires the system to use O(N) size stack space.
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp=root.left;
        root.left = invertTree(root.right);
        root.right=invertTree(tmp);
        return root;
    }

    public TreeNode invertTree_stack(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left!=null) stack.add(node.left);
            if(node.right!=null) stack.add(node.right);

            TreeNode tmp=node.left;
            node.left=node.right;
            node.right = tmp;
        }
        return root;
    }
}
