package DesignDataStructure;

public class MyStackByArray {
    private int head;
    private int size;
    private int[] array;

    private static final int DEFAULT_CAPACITY = 10;

    public MyStackByArray(int capacity){
        array = new int[capacity];
        head = 0;
        size = 0;
    }

    public MyStackByArray(){
        this(DEFAULT_CAPACITY);
    }

    public boolean push(int val){
        if (size == array.length) return false;

        array[head++] = val;
        size++;
        return true;
    }

    public int pop(){
        if (size <= 0) throw new IllegalArgumentException("");
        int popVal = array[--head];
        size--;
        return popVal;
    }

    public int peek(){
        return size == 0 ? -1 : array[head - 1];
    }
}
