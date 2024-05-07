package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/permutations/description/">permutations</a>
 */
public class Permutations {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    /**
     * Recall_DFS
     * TC: O(n*n!)  the permutation of each element is n!, and the number of element is n
     * SC: O(n)  use dfs() so use the system stack space
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            path.add(num);
        }
        dfs(0);
        return res;
    }

    private void dfs(Integer x) {
        if (x == path.size() - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = x; i < path.size(); i++) {
            //this step means fix nums[i] at the x-th position
            swap(i, x);
            dfs(x + 1);
            //undo exchange
            swap(x, i);
        }
    }

    private void swap(int a, int b) {
        int tmp = path.get(a);
        path.set(a, path.get(b));
        path.set(b, tmp);
    }
}
