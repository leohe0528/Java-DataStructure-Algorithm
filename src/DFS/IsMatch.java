package DFS;

public class IsMatch {

    public boolean isMatch(String s, String p){
        if (s == null || p == null) return false;
        return helper(s , 0, p, 0);
    }
    private boolean helper(String s, int idxS, String p, int idxP){
        int lenP = p.length(), lenS = s.length();

        if (idxP == lenP){
            return idxS == lenS;
        }else if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*'){
            if (idxS < lenS && (p.charAt(idxP) == '.'
                                || p.charAt(idxP) == s.charAt(idxS))){
                return helper(s, idxS + 1, p, idxP + 1);
            }else{
                return false;
            }
        }else{
            int i = idxS - 1;
            while (i < lenS &&          //当等于*时候的分叉，要么match要么往后看
                    (i < idxS || p.charAt(idxP) == '.' ||
                                 p.charAt(idxP) == s.charAt(i))){
                if (helper(s, i + 1, p, idxP + 2)){
                    return true;
                }
                i++;
            }
            return false;
        }
    }
//    public boolean isMatch2(String s, String p) {
//        if (s == null || p == null) return false;
//        return helper(s, 0, p, 0);
//    }
//    private boolean helper(String s, int idxS, String p, int idxP){
//        int lenS = s.length(), lenP = p.length();
//        if (idxP == lenP) return idxS == idxS;
//
//        if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*'){
//            if (idxS < lenS && isMatched(s, idxS, p, idxP)){
//                return helper(s, idxS + 1, p, idxP + 1);
//            }else{
//                return false;
//            }
//        }else{
//            int i = idxS - 1;
//            while (i < lenS && (i == idxS - 1 || isMatched(s, i, p, idxP))){
//                if (helper(s, i + 1, p, idxP + 2)){
//                    return true;
//                }
//                i++;
//            }
//            return false;
//        }
//    }
//    private boolean isMatched(String s, int idxS, String p, int idxP){
//        return p.charAt(idxP) == '.' || (p.charAt(idxP) == s.charAt(idxS));
//    }

    public static void main(String[] args){
        String a = "aa";
        String b = "a";
        boolean res = new IsMatch().isMatch(a, b);
        System.out.println(res);
    }
}
