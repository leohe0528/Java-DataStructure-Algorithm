package Sort;

public class InsertionSort {

    public static void insertionSort(int[] array){
        if (array == null || array.length == 0) return;
        int key = 0;
        for (int i = 1; i < array.length; i++){
            key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args){
        int[] arr = {6, 4, 6, 2, 4, 3, 8, 9, 4, 3};
        insertionSort(arr);
        utils.printArray(arr);
    }
}
