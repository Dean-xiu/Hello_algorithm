package queue_and_stack;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/find-median-from-data-stream/description/">find-median-from-data-stream</a>
 */
public class FindMedianFromDataStream {
    /**
     * heap
     * TC: addNum O(logN)  findMedian O(1)
     * SC: O(n)  the sum of the capacity of minQueue and maxQueue
     */
    Queue<Integer> minQueue, maxQueue;
    public FindMedianFromDataStream() {
        // priority queue is heap in java
        //minQueue: the head of queue is minimum value
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((a, b) -> b - a);
    }

    /**
     * maxQueue: from large to small  minQueue: from small to large
     * maxQueue + minQueue form a reverse order
     * @param num
     */
    public void addNum(int num) {
        if (minQueue.size() != maxQueue.size()) {
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        } else {
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        return minQueue.size() != maxQueue.size() ? minQueue.peek() : (minQueue.peek() + maxQueue.peek()) / 2.0;
    }
}
