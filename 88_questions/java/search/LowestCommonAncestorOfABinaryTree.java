package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/">lowest-common-ancestor-of-a-binary-tree</a>
 */
public class LowestCommonAncestorOfABinaryTree {
    /**
     * DFS
     * TC: O(n)  n is the number of binary tree
     * SC: O(n)  Recursive call stack depth
     */
    private TreeNode ans = null;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;
        //lson/rson-> Whether the left/right tree of current root has p or q
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        //(lson && rson)-> p,q are respectively in the left and right subtrees of the current root
        //((root.val == p.val || root.val == q.val) && (lson || rson))-> the current root is q/p,and p/q is in the left or right subtree of q/p
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor_Dfs1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }


    /**
     * HashMap
     * TC: O(n)
     * SC: O(n)
     */
    Map<Integer, TreeNode> parents = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    private void dfs_storeParent(TreeNode root) {
        //store the parents of left subtree
        if (root.left!= null) {
            parents.put(root.left.val, root);
            dfs_storeParent(root.left);
        }

        //store the parents of right subtree
        if (root.right != null) {
            parents.put(root.right.val, root);
            dfs_storeParent(root.right);
        }
    }
    public TreeNode lowestCommonAncestor_HashMap(TreeNode root, TreeNode p, TreeNode q) {
        //store parent of each node
        dfs_storeParent(root);

        //visited from p -> ancestor of p node
        while (p != null) {
            visited.add(p.val);
            p = parents.get(p.val);
        }

        //visited from q -> ancestor of q node
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parents.get(q.val);
        }
        return null;
    }


    /**
     * recursion
     * TC: O(n)  Recursively iterate over all nodes
     * SC: O(n)  use system space stack
     */
    public TreeNode lowestCommonAncestor_Dfs2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor_Dfs2(root.left, p, q);
        TreeNode right = lowestCommonAncestor_Dfs2(root.right, p, q);
        //Neither pq is in the left subtree, indicating that it exists in the right subtree, and vice versa
        if(left==null) return right;
        if(right==null) return  left;
        //left and right all exist node, meaning that p,q are in the left and right subtrees respectively
        return root;
    }
}
