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

    //using binary search
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            int pos = binarySearch(dp,len,nums[i]);
            if (nums[i] < dp[pos]) dp[pos] = nums[i];
            if (pos > len) {
                len = pos;
                dp[len] = nums[i];
            }
        }
        return len+1;
    }
    private int binarySearch(int[] nums, int len, int target) {
        int left = 0, right = len;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }



    public static void main(String[] args){
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = new LIS().lengthOfLIS2(nums);
        System.out.println(res);
    }
}
