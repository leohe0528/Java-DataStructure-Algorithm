package ArrayAndString;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            //deque: empty
            if (deque.isEmpty()) deque.offer(nums[i]);
                //
            else {
                while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
            }

            if (deque.size() == k + 1 || (i - k >= 0 && deque.peek() == nums[i - k])) deque.pollFirst();

            if (i >= k - 1) res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {7, 2, 4};
        int k = 2;
        int[] res = new MaxSlidingWindow().maxSlidingWindow(nums, k);
    }
}
