package Sort;

public class BubbleSort {

    public static void bubbleSort(int[] array){
        //corner case
        if (array == null || array.length == 0) return;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    utils.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args){
//        int[] arr = {6, 4, 6, 2, 4, 3, 8, 9, 4, 3};
//        bubbleSort(arr);
//        utils.printArray(arr);
        String a = "-20";
        int b = Integer.parseInt(a);
        System.out.println(b);
    }
}
