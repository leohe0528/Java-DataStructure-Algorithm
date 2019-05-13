package Sort;

public class SelectionSort {

    public static void selectionSort(int[] array){
        if (array == null || array.length == 0) return;
        int minInd = 0;
        for (int i = 0; i < array.length; i++){
            minInd = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[minInd] > array[j])
                    minInd = j;
            }
            utils.swap(array, minInd, i);
        }
    }

    public static void main(String[] args){
        int[] arr = {6, 4, 6, 2, 4, 3, 8, 9, 4, 3};
        selectionSort(arr);
        utils.printArray(arr);
    }
}
