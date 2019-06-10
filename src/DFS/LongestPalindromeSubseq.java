package DFS;

public class LongestPalindromeSubseq {
    private int maxSubseq = 1;
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;

        Integer[] mem = new Integer[s.length() + 1];
        helper(s, 0, new StringBuilder(), mem);
        return maxSubseq;
    }

    private int helper(String s, int index, StringBuilder path, Integer[] mem)
    {
        if (isPalindrome(path.toString()) && path.length() > maxSubseq)
        {
            maxSubseq = path.length();
        }
        if (mem[index] != null) return mem[index];


        int max = 1;
        for (int i = index; i < s.length(); i++)
        {
            int len = path.length();
            path.append(s.charAt(i));
            max = Math.max(max, helper(s, i + 1, path, mem));
            path.setLength(len);
        }
        mem[index] = max;
        return max;
    }

    private boolean isPalindrome(String s)
    {
        int left = 0, right = s.length() - 1;
        while (left <= right)
        {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String input = "bbbab";
        int res = new LongestPalindromeSubseq().longestPalindromeSubseq(input);
    }
}
