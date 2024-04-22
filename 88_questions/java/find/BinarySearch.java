package find;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/binary-search/description/">binary-search</a>
 */
public class BinarySearch {
    /**
     * Binary search
     * TC: O(logn)  n is the length of nums
     * SC: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
