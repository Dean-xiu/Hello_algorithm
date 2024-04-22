package find;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/description/">find-minimum-in-rotated-sorted-array-ii</a>
 */
public class FindMinimumInRotatedSortedArrayII {
    /**
     * Binary search
     * TC: O(logn)  n is the length of nums
     * SC: O(1)
     * @param nums
     * @return
     */
    public int findMin_BinarySearch(int[] nums) {
        if(nums.length==1) return nums[0];

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            //pivot is greater than right boundary means minimum range is [mid+1,r]
            if(nums[mid]>nums[r]) l=mid+1;
            //pivot is less than right boundary means minimum range is [l,mid],
                // and mid is taken because mid may be the minimum
            else if(nums[mid]<nums[r]) r=mid;
            //pivot equal the right boundary, if right boundary is minimum,
                // it will find pivot after r--, if right boundary is not minimum, the range is still correct
            else r--;
        }
        return nums[l];
    }


    /**
     * Iteration
     * TC: O(n)  iterate over the array
     * SC: O(1)
     * @param nums
     * @return
     */
    public int findMin_iteration(int[] nums) {
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i]<nums[i-1])
                return nums[i];
        }
        return nums[0];
    }
}
