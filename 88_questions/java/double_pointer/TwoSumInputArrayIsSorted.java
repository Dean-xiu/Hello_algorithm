package double_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">two-sum-ii-input-array-is-sorted</a>
 */
public class TwoSumInputArrayIsSorted {
    /**
     * Binary search
     * TC: O(nlogn)  n is the length of numbers, logn is the TC of binary search
     * SC: O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum_binarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;

            //binary search to find another number
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                }else if(numbers[mid]>target-numbers[i]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }

            }
        }
        return new int[]{-1, -1};
    }


    /**
     * double pointer
     * TC: O(n)  n is the length of the numbers
     * SC: O(1)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum_doublePointer(int[] numbers, int target){
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum==target){
                return new int[]{low+1, high+1};
            } else if (sum > target) {
                high--;
            }else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }
}
