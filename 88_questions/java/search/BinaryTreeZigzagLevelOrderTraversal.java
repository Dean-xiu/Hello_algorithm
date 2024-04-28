package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">binary-tree-zigzag-level-order-traversal</a>
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * BFS
     * TC: O(n)  n is the number of binary tree, bfs required n cycles
     * SC: O(n)  the capacity of queue
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //row is a deque
            LinkedList<Integer> row = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                //the current row is odd row, should be stored forward
                if (res.size() % 2 == 0) {
                    row.addLast(tmp.val);
                }else {
                    //the current row is even number line, should be stored in reverse
                    row.addFirst(tmp.val);
                }

                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);
            }
            res.add(row);
        }
        return res;
    }
}
