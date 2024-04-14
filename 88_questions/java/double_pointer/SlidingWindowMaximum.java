package double_pointer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/sliding-window-maximum/description/">sliding-window-maximum</a>
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0)
            return new int[0];
        //the number of sliding windows is n-k+1
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();

        //no window formed
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        //After forming the window
        for (int i = k; i < nums.length; i++) {
            //num[i-k] will no longer be in the window at all, and the head of the queue can be removed
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(ints);
    }
}
