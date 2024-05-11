package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/combination-sum/description/">combination-sum</a>
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        //sort candidates for pruning
        Arrays.sort(candidates);

        int start=0;
        backTrack(candidates, target, start, state, res);
        return res;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> state, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //pruning 1: due to the array has been sorted, so if candidates[i] doesn't match, the rest of array doesn't match either
            if (target-candidates[i] < 0) {
                break;
            }

            //try to put candidates[i] into states
            state.add(candidates[i]);
            //Proceed to the next round of selection, Since the selection can be repeated, the next round also starts from the current bit
            //so start=i
            backTrack(candidates, target - candidates[i], i, state, res);
            //Undo the selection and revert to the previous state
            state.remove(state.size()-1);
        }
    }
}
