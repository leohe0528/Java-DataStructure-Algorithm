package DesignDataStructure;

public class MyQueueByArray {
    private int size;
    private int head;
    private int tail;
    private int[] array;

    private static final int DEFAULT_CAPACITY = 10;

    //为什么不写第二个constructor 第一个会报错
    public MyQueueByArray(){
        this(DEFAULT_CAPACITY);
    }

    public MyQueueByArray(int capacity){
        array = new int[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    //offer poll peek getSize
    public boolean offer(int val){
        if (size == array.length) return false;

        array[tail] = val;
        tail = (tail + 1) % array.length;

        size++;
        return true;
    }

    public int poll(){
        if (size <= 0) throw new IllegalArgumentException("");

        int pollVal = array[head];
        head = (head + 1) % array.length;

        size--;
        return pollVal;
    }

    public int peek(){
        if (size == 0) throw new IllegalArgumentException("");
        return array[head];
    }

    private void printArray(){
        for (int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    private int getHead(){
        return head;
    }

    private int getTail(){
        return tail;
    }


}
