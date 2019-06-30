package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class ArrayReader {
    private List<Integer> array;
    public ArrayReader(){
        array = new ArrayList<>();
    }
    public int get(int target){
        return array.get(target);
    }
}
