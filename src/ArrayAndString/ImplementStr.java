package ArrayAndString;

public class ImplementStr {
    public int strStr(String haystack, String needle) {
        //cc
        if (needle.length() == 0) return 0;
        if (haystack == null || needle == null || haystack.length() == 0 || needle.length() == 0)
            return -1;
        if (haystack.length() < needle.length()) return -1;

        int lenP = needle.length();
        int lenS = haystack.length();

        int hashP = getHashCode(needle, 0, lenP);
        int hashS = getHashCode(haystack, 0, lenP);
        if (hashP == hashS && haystack.substring(0, lenP).equals(needle)) return 0;
        for (int i = lenP; i < lenS; i++){
            hashS = hashS + (haystack.charAt(i) - 'a') - (haystack.charAt(i - lenP) - 'a');
            if (hashS == hashP && haystack.substring(i - lenP + 1, i + 1).equals(needle)){
                return i - lenP + 1;
            }
        }
        return -1;
    }

    public int getHashCode(String str, int start, int end){
        int hashCode = 0;
        for (int i = start; i < end; i++){
            hashCode += str.charAt(i) - 'a';
        }
        return hashCode;
    }

    public static void main(String[] args){
        String a = "mississippi";
        String b = "issip";
        int res = new ImplementStr().strStr(a, b);
    }
}
