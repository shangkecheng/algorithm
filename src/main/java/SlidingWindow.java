import java.util.LinkedList;

/**
 * Created by lucaskc on 2017/5/16.
 */
public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }

            queue.offerLast(i);
            //判定队列头下标是否在窗口之内

            if(i >= k-1){
                result[i-k+1] = nums[queue.peekFirst()];
            }
        }
        return result;
    }
}

