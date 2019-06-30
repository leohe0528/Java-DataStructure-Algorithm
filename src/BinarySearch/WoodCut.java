package BinarySearch;

//Given n pieces of wood with length L[i] (integer array).
// Cut them into small pieces to guarantee you could have equal
// or more than k pieces with the same length.
// What is the longest length you can get from the n pieces of wood? Given L & k,
// return the maximum length of the small pieces.

//Example
//Example 1
//
//Input:
//L = [232, 124, 456]
//k = 7
//Output: 114
//Explanation: We can cut it into 7 pieces if any piece is 114cm long, however we can't cut it into 7 pieces if any piece is 115cm long.
//Example 2
//
//Input:
//L = [1, 2, 3]
//k = 7
//Output: 0
//Explanation: It is obvious we can't make it.
//Challenge
//O(n log Len), where Len is the longest length of the wood


public class WoodCut {
    public int woodCut(int[] L, int k){
        if (L == null || L.length == 0 || countPieces(L, 1) < k) return 0;

        int maxLen = 0;
        for (int i = 0; i < L.length; i++){
            maxLen = Math.max(maxLen, L[i]);
        }

        int shortestLen = 1, longestLen = maxLen;
        while (shortestLen + 1 < longestLen){
            int midLen = shortestLen + (longestLen - shortestLen) / 2;
            if (countPieces(L, midLen) >= k) shortestLen = midLen;
            else longestLen = midLen;
        }
        if (countPieces(L, longestLen) >= k) return longestLen;
        return shortestLen;
    }

    private long countPieces(int[] L, int len){
        long pieces = 0;
        for (int i = 0; i < L.length; i++){
            pieces += L[i] / len;
        }
        return pieces;
    }

    public static void main(String[] args){
//        int[] L = new int[]{232,124,456};
        int[] L = new int[]{2147483644,2147483645,2147483646,2147483647}; //在count piece那里用long
//        int[] L = new int[]{1, 2, 3};
        int k = 4;
        WoodCut woodCut = new WoodCut();
        int len = woodCut.woodCut(L, k);
        System.out.println(len);
    }
}
