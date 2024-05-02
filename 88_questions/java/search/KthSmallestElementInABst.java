package search;

import java.util.Stack;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/">kth-smallest-element-in-a-bst</a>
 */
public class KthSmallestElementInABst {
    /**
     * dfs_recursive
     * TC: O(n)
     * SC: O(n)  use the system stack space
     */
    int res,k;

    private void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.left);
        if(k==0) return;
        if(--k==0) res = root.val;
        dfs(root.right);
    }
    public int kthSmallest_Dfs(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return res;
    }


    /**
     * dfs_stack
     * TC: O(n)
     * SC: O(n)
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_Stack(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return -1;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k==0) return root.val;
            root = root.right;
        }
        return -1;
    }
}
