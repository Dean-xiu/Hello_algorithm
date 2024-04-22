package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">binary-tree-level-order-traversal</a>
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * Queue(BFS)
     * TC: O(n)  n is the number of node of tree
     * SC: O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                row.add(tmp.val);
                if(tmp.left!=null) queue.offer(tmp.left);
                if(tmp.right!=null) queue.offer(tmp.right);
            }
            res.add(row);
        }
        return res;
    }
}
