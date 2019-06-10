package DFS;


//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//        Example:
//
//        Input: [-2,1,-3,4,-1,2,1,-5,4],
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.

public class MaximumSubarray {
//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int res = 0;
//        int len = nums.length;
//        Integer[] mem = new Integer[len];
//        for (int i = 0; i < len; i++){
//            res = Math.max(res, helper(nums, i, mem, 0));
//        }
//        return res;
//    }
//    private int helper(int[] nums, int index, Integer[] mem, int currSum){
//        if (mem[index] != null) return mem[index];
//        int res = 0;
//        for (int j = 0; j < index; j++){
//           if (nums[j] >= currSum){
//               res = Math.max(res, helper(nums, j, mem, currSum + nums[j]));
//           }
//        }
//        mem[index] =res;
//        return res;
//    }
public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int maxSum = 0;
    for (int i = 0; i < nums.length; i++){
        maxSum = Math.max(maxSum, helper(nums, i));
    }
    return maxSum;
}

    private int helper(int[] nums, int index)
    {
        int res = nums[index];
        for (int i = index + 1; i < nums.length; i++)
        {
            int val = helper(nums, i);
            if (val > 0){
                res += val;
                System.out.println("res: " + res);

            }else{
                break;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int solution = new MaximumSubarray().maxSubArray(nums);
    }
}
