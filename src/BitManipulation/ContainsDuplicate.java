package BitManipulation;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int res = 0;
        for (int num : nums){
            if ((res >> num & 1) == 1){
                return true;
            }
            res = (res | (1 << num));
        }
        return false;
    }

    public static void main(String[] args){
        int[] a = {1, 2, 3, 1};
        boolean res = new ContainsDuplicate().containsDuplicate(a);
    }
}
