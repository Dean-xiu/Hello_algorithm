package search;

import java.util.Arrays;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/find-pivot-index/description/">find-pivot-index</a>
 */
public class FindPivotIndex {
    /**
     * Iterate
     * TC: O(n)  n is the length of the array
     * SC: O(1)
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum();

        //iterate over the entire array
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
