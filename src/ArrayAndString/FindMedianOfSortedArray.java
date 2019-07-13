package ArrayAndString;

public class FindMedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N = nums1.length + nums2.length;
        if (N % 2 == 1){
            return findMedian(nums1, 0, nums2, 0, N / 2 + 1);
        }else{
            return (findMedian(nums1, 0, nums2, 0, N / 2) +
                    findMedian(nums1, 0, nums2, 0, N / 2 + 1)) / 2.0;
        }
    }

    private double findMedian(int[] nums1, int nums1Start, int[] nums2, int nums2Start, int k){
        if (nums1Start >= nums1.length) return nums2[nums2Start + k - 1];
        if (nums2Start >= nums2.length) return nums1[nums1Start + k - 1];

        if (k == 1) return Math.min(nums1[nums1Start], nums2[nums2Start]);

        int num1Mid = Integer.MAX_VALUE;
        int num2Mid = Integer.MAX_VALUE;

        int i = k / 2 - 1;
        if (nums1Start + i < nums1.length) num1Mid = nums1[nums1Start + i];
        if (nums2Start + i < nums2.length) num2Mid = nums2[nums2Start + i];

        if (num1Mid < num2Mid){
            return findMedian(nums1, nums1Start + i + 1, nums2, nums2Start, k - i - 1);
        }else{
            return findMedian(nums1, nums1Start, nums2, nums2Start + i + 1, k - i - 1);
        }
    }
    public static void main(String[] args){
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        double res = new FindMedianOfSortedArray().findMedianSortedArrays(a, b);
        System.out.println(res);
    }
}
