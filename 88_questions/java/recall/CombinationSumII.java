package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/combination-sum-ii/description/">combination-sum-ii</a>
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> state = new ArrayList<>();
        Arrays.sort(candidates);

        int start = 0;
        backTrack(candidates, target, start, state, res);
        return res;
    }

    private static void backTrack(int[] candidates, int target, int start, List<Integer> state, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //pruning 1: The array is sorted, and if the current element does not meet the condition, the subsequent elements will not
            if (target - candidates[i] < 0) {
                break;
            }

            //pruning 2: skip the repeat element
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            //try to select candidates as result
            state.add(candidates[i]);
            //proceed the next round of selection,due to each element only use once
            //so start=i+1
            backTrack(candidates, target - candidates[i], i + 1, state, res);
            //Undo the selection and revert to the previous state
            state.remove(state.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        combinationSum2(candidates, 5);
    }
}
