package search;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/find-the-duplicate-number/description">find-the-duplicate-number</a>
 */
public class FindTheDuplicateNumber {
    /**
     * Ring Linked List
     * TC: O(n)  n is the length of array nums, the iteration takes O(n)
     * SC: O(1)  no extra space
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];

        //The fist meeting of slow and fast pointer means encounter in the ring
        int slow=0, fast=0;
        do {
            //Maps an array to a linked list with a ring
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //reset the slow pointer
        slow = 0;
        //The point of second encounter is the entrance of ring, which is also repeating element
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
