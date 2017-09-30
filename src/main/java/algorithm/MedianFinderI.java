package algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by lucaskc on 2017/5/19.
 */
public class MedianFinderI {
    public PriorityQueue<Integer> minheap, maxheap;

    public MedianFinderI() {
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minheap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }

    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }
}
