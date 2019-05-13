package Sort;

public class MergeSort {

    public static void mergeSort(int[] array){
        if (array == null || array.length == 0) return;
        int[] helper = new int[array.length];
        divideAndMerge(array, 0, array.length - 1, helper);

    }

    public static void divideAndMerge(int[] array, int left, int right, int[] helper){
        //base case 不要忘记base case 当用recursion的时候！！！！！
        if (left == right) return;
        int mid = left + (right - left) / 2;
        divideAndMerge(array, left, mid, helper);
        divideAndMerge(array, mid + 1, right, helper);
        merge(array, left, mid, right, helper);
    }

    public static void merge(int[] array, int left, int mid, int right, int[] helper){
        //把sorted好的左右array先复制到helper
        for (int i = left; i <= right; i++){
            helper[i] = array[i];
        }

        //左右array的elements进行比较
        int leftI = left;
        int rightI = mid + 1;
        while (leftI <= mid && rightI <= right){
            if(helper[leftI] <= helper[rightI])
                array[left++] = helper[leftI++];
            else
                array[left++] = helper[rightI++];
        }
        //这种情况出现是，rightI已经到顶了leftI还没，left array剩余一些较大的数字还没填充到array上面
        while (leftI <= mid){
            array[left++] = helper[leftI++];
        }

//        while (rightI <= right){
//            array[left++] = array[rightI++];
//        }
    }

    public static void main(String[] args){
        int[] arr = {6, 4, 6, 2, 4, 3, 8, 9, 4, 3};
//        int[] arr2 = {8, 7, 6, 5, 3, 4, 1};
        mergeSort(arr);
        utils.printArray(arr);
    }
}
