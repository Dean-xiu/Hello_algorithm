package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/">kth-largest-element-in-an-array</a>
 */
public class KthLargestElementInAnArray {
    /**
     * quickSelect
     * TC: O(n)
     * SC: O(logn)  The average recursion depth of partition functions is O(logn).
     * @param nums
     * @param k
     * @return
     */
    private static int quickSelect(List<Integer> nums, int k) {
        Random random = new Random();
        //use random number to get base number
        int pivot = nums.get(random.nextInt(nums.size()));
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }

        if (k <= big.size()) {
            return quickSelect(big, k);
        }
        if (big.size() + equal.size() < k) {
            return quickSelect(small, k - big.size() - equal.size());
        }
        return pivot;
    }
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickSelect(list, k);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int num = findKthLargest(nums, 2);
        System.out.println(num);
    }


}
