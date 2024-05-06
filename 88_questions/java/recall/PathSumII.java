package recall;

import search.TreeNode;

import java.util.*;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/path-sum-ii/description/">path-sum-ii</a>
 */
public class PathSumII {
    /**
     * DFS_preorder traversal
     * TC: O(n)  n is the number of tree node
     * SC: O(n)  overhead of stack space
     *
     * @param root
     * @param targetSum
     * @return
     */
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum_Dfs(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if(root==null) return;
        path.addLast(root.val);
        targetSum -= root.val;
        if (targetSum == 0 && root.right == null && root.left == null) {
            //if just use res.add(path), when path changed, the res will change
            res.add(new LinkedList<>(path));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.removeLast();
    }

    /**
     * BFS
     * TC: O(n)
     * SC: O(n)
     *
     * @param root
     * @param targetSum
     * @return
     */
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    public List<List<Integer>> pathSum_BFS(TreeNode root, int targetSum) {
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queue.offer(root);
        queueSum.offer(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int sum = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    parent.put(node.left, node);
                    queue.add(node.left);
                    queueSum.add(sum);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    queue.add(node.right);
                    queueSum.add(sum);
                }
            }
        }
        return res;
    }

    private void getPath(TreeNode node) {
        LinkedList<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.addFirst(node.val);
            node = parent.get(node);
        }
        res.add(temp);
    }
}
