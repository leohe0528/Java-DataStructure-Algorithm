package DynamicProgramming;

public class PalindromePartitioningII {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        boolean[][] isPal = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--){
            for (int j = i; j < len; j++){
                if (s.charAt(i) == s.charAt(j) &&
                        (i == j || i + 1 == j ||
                                isPal[i + 1][j - 1])){
                    dp[i] = Math.min(dp[j + 1] + 1, dp[i]);
                    isPal[i][j] = true;
                }
            }
        }
        return dp[0] - 1;
    }
    public static void main(String[] args){
        String a = "aab";
        int res = new PalindromePartitioningII().minCut(a);
    }
}
