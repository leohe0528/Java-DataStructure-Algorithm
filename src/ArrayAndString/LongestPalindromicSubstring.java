package ArrayAndString;

public class LongestPalindromicSubstring {

    private String res = "";
    public String longestPalindrome(String s) {
        if (s == null) return s;
        for (int i = 0; i < s.length() - 1; i++){
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }
    private void helper(String s, int left, int right){
        if (s == null || left < 0 || right >= s.length()) return;

        if (s.charAt(left) == s.charAt(right)){
            if (right - left + 1 > res.length()){
                res = s.substring(left, right + 1);
            }
            helper(s, --left, ++right);
        }
    }

    public static void main(String[] args){
        String s = "abcdbbfcba";
        String res = new LongestPalindromicSubstring().longestPalindrome(s);
    }
}
