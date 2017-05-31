import java.util.*;

/**
 * Created by lucaskc on 2017/5/20.
 */
public class MaxSlidingWindow {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList result =  new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0 ; i<nums.length;i++){
            while(!queue.isEmpty()&& nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            while(!queue.isEmpty()&& queue.peekFirst()<i-k+1){
                queue.pollFirst();
            }
            queue.offerLast(i);

            if(i>=k-1){
                result.add(queue.peekFirst());
            }

        }
        return result;

    }
}
