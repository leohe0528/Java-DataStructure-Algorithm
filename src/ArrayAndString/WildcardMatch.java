package ArrayAndString;

public class WildcardMatch {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int jStar = -1;
        int iStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++i;  ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                jStar = j++;
                iStar = i;
            } else if (iStar >= 0) {
                j = jStar + 1;
                i = ++iStar;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();
    }
    public static void main(String[] args){
        String s = "aa";
        String p = "*";
        boolean res = new WildcardMatch().isMatch(s, p);
    }
}
