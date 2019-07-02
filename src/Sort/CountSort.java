package Sort;

public class CountSort {
    public void countSort(char[] array){
        int[] count = new int[256];
        char[] ouput = new char[array.length];
        for (int i = 0; i < array.length; i++){
            count[array[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++){
            while (count[i] > 0){
                ouput[idx++] = (char)i;
                count[i]--;
            }
        }

        for (int i = 0; i < ouput.length; i++){
            System.out.print(ouput[i] + " ");
        }

    }

    public static void main(String[] args){
        int[] nums = new int[]{6, 4, 6, 2, 4, 3, 8, 9, 4, 3};
        String s = "geeks";
        char[] array = s.toCharArray();
        CountSort countSort = new CountSort();
        countSort.countSort(array);

    }
}
