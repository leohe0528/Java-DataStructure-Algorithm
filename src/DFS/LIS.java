package DFS;

public class LIS {
    public int lengthOfLIS(int[] nums) {

        int res = 1;
        Integer[] memo = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++){
            res = Math.max(helper(nums, i, memo), res);
        }
        return res;
    }
    private int helper(int[] nums, int index, Integer[] memo){
        if (memo[index] != null) return memo[index];

        int res = 1;
        for (int j = 0; j < index; j++){
            if (nums[index] > nums[j]){
                res = Math.max(res, helper(nums, j, memo) + 1);
            }
        }
        memo[index] = res;
        return res;
    }
    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7};
        int res = new LIS().lengthOfLIS(nums);
        System.out.println(res);
    }
}
