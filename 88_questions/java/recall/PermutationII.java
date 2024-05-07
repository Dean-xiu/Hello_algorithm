package recall;

import java.util.*;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/permutations-ii/description/">permutations-ii</a>
 */
public class PermutationII {
    static List<List<Integer>> res = new ArrayList<>();

    static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            path.add(num);
        }
        Collections.sort(path);
        dfs(0);
        return res;
    }

    private static void dfs(int x) {
        if (x == path.size() - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = x; i < path.size(); i++) {
            //if it is repeat element, skip it
            if (set.contains(path.get(i))) {
                continue;
            }
            set.add(path.get((i)));
            //fixed num[i] at the x-th position
            swap(i, x);
            dfs(x + 1);
            //undo exchange
            swap(x, i);
        }
    }

    private static void swap(int a, int b) {
        int tmp = path.get(a);
        path.set(a, path.get(b));
        path.set(b, tmp);
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permuteUnique(nums);
        for (List<Integer> row : result) {
            System.out.println(Arrays.toString(row.toArray()));
        }
    }
}
