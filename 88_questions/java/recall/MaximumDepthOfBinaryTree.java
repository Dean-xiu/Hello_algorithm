package recall;

import com.sun.source.tree.Tree;
import search.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">maximum-depth-of-binary-tree</a>
 */
public class MaximumDepthOfBinaryTree {
    /**
     * DFS_recursion
     * TC: O(n)  n is the number of the tree node
     * SC: O(n)  the depth will be n when the tree is reduced to a linked list
     * @param root
     * @return
     */
    public int maxDepth_Dfs1(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth_Dfs1(root.left), maxDepth_Dfs1(root.right))+1;
    }


    /**
     * BFS
     * TC: O(n)
     * SC: O(n)
     * @param root
     * @return
     */
    public int maxDepth_BFS(TreeNode root) {
        if(null==root) return 0;
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        int res = 0;

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if(null!=tmp.left) queue.add(tmp.left);
                if(null!=tmp.right) queue.add(tmp.right);
            }
        }
        return res;
    }
}
