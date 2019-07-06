package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KInversePairs {
    public int kInversePairs(int n, int k) {
        if (n == 0) return 0;
        List<List<Integer>> listsOfPermutation = getListsOfPermutation(n);
//        for (int i = 0; i < listsOfPermutation.size(); i++){
//            List<Integer> list = listsOfPermutation.get(i);
//            for (int j = 0; j < n; j++){
//                System.out.print(list.get(j) + " ");
//            }
//            System.out.println("");
//        }

        int res = 0;
        for (int i = 0; i < listsOfPermutation.size(); i++){
            List<Integer> currList = listsOfPermutation.get(i);
            int countInverse = 0;
            for (int j = 0; j < n - 1; j++){
                for (int p = j + 1; p < n; p++){
                    if (currList.get(j) > currList.get(p)){
                        countInverse++;
                    }
                }
                if (countInverse > k) break;
            }
            if (countInverse == k) {
                res++;
//                System.out.println(i);
            }
        }
        return res;
    }

    private List<List<Integer>> getListsOfPermutation(int n){
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) return res;
        Set<Integer> set = new HashSet<>();
        helper(n, new ArrayList<Integer>(), res, set);
        return res;
    }

    private void helper(int n, List<Integer> curr, List<List<Integer>> res,
                        Set<Integer> set){
        if (curr.size() == n){
            res.add(new ArrayList<>(curr));
        }

        for (int i = 1; i <= n; i++){
            if (set.contains(i)) continue;
            curr.add(i);
            set.add(i);
            helper(n, curr, res, set);
            curr.remove(curr.size() - 1);
            set.remove(i);
        }
    }

    public static void main(String[] args){
        int n = 3;
        int k = 0;
        int res = new KInversePairs().kInversePairs(n, k);
    }

}
