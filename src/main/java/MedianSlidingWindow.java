import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by lucaskc on 2017/5/20.
 */
public class MedianSlidingWindow {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here

        ArrayList list = new ArrayList<Integer>();
        if(nums==null||nums.length==0 || k==0 ) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (i >= k - 1) {
                list.add(getMedian());
                remove(nums[i]);
            }
        }
        return list;
    }
    private void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else {
            return (double)minHeap.peek();
        }
    }
}

