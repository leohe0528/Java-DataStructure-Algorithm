package BinarySearch;

public class SearchInABigArray {
    public int searchBigSortedArray(ArrayReader reader, int target){
        if (reader == null || reader.get(0) == Integer.MAX_VALUE) return -1;
        if (reader.get(0) > target) return -1;

        int[] range = computeRange(reader, target);
        if (range == null) return -1;
        int res = binarySearch(reader, range[0], range[1], target);
        return res;
    }

    private int[] computeRange(ArrayReader reader, int target){
        int right = 0;
        while (reader.get(right) < target){
            right <<= 1;
        }
        int left = right >> 1;

        while (left <= right && reader.get(right) == Integer.MAX_VALUE){
            right--;
        }
        if (right < left) return null;
        return new int[]{left, right};
    }

    private int binarySearch(ArrayReader reader, int left, int right, int target){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) return mid;
            else if (reader.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
