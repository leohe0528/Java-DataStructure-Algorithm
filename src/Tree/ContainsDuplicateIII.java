package Tree;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++){
            if (treeSet.size() > k) treeSet.remove(Long.valueOf(nums[i - k - 1]));

            long upperBound = t + (long)nums[i];
            long lowerBound = -t + (long)nums[i];
            Long x = treeSet.floor(upperBound);
            if (x != null && x >= lowerBound) return true;
            treeSet.add(Long.valueOf(nums[i]));
        }
        return false;
    }
    public static void main(String[] args){
        int[] nums = {1,5,9,1,5,9};
        int k = 2, t = 3;
        boolean res = new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums, k, t);
    }
}
