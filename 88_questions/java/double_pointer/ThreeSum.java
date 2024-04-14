package double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/3sum/description">3sum</a>
 */
public class ThreeSum {
    /**
     * Sort + Double pointer
     * TC: O(n^2)  double cycle
     * SC: O(1)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);


        //fix a value
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) break;
            //avoid repeating number
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    //avoid repeating number
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }
}
