package Sort;

public class QuickSort {

    public static void quickSort(int[] array){
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right){
        if (left >= right) return;

        int partition = partition3(array, left, right);
        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    public static int partition1(int[] array, int left, int right){
        int pivot = left + (right - left) / 2;
        utils.swap(array, pivot, left);
        int leftI = left + 1; // pivot is mid, but we need to move the pivot to left/right. left in this case
        int rightI = right;
        int pivotVal = array[left];
        while (leftI <= rightI){
            if (array[leftI] <= pivotVal) leftI++;
            else if (array[rightI] > pivotVal) rightI--;
            else utils.swap(array, leftI++, rightI--);
        }
        utils.swap(array, left, rightI);
        return rightI;
    }

    public static int partition2(int[] array, int left, int right){
        int leftI = left + 1; // pivot is left
        int rightI = right;
        int pivotVal = array[left];
        while (leftI <= rightI){
            if (array[leftI] <= pivotVal) leftI++;
            else if (array[rightI] > pivotVal) rightI--;
            else utils.swap(array, leftI++, rightI--);
        }
        utils.swap(array, left, rightI);
        return rightI;
    }

    public static int partition3(int[] array, int left, int right){
        int leftI = left;
        int rightI = right - 1;  //pivot is right
        int pivotVal = array[right];
        while (leftI <= rightI){
            if (array[leftI] <= pivotVal) leftI++;
            else if (array[rightI] > pivotVal) rightI--;
            else utils.swap(array, leftI++, rightI--);
        }
        utils.swap(array, right, leftI);
        return leftI;
    }

    public static void main(String[] args){
        int[] arr = {6, 4, 6, 2, 4, 3, 8, 9, 4, 3};
//        int[] arr2 = {8, 7, 6, 5, 3, 4, 1};
        quickSort(arr);
        utils.printArray(arr);
    }
}
