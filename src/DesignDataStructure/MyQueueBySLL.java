package DesignDataStructure;

public class MyQueueBySLL {
    //fields
    private ListNode head;
    private ListNode tail;
    private int size;

    //methods: constructor, offer, poll, peek, getSize

    //constructor
    public MyQueueBySLL(){
        head = null;
        tail = null;
        size = 0;
    }

    //overloading: constructor
    public MyQueueBySLL(int val){
        head = new ListNode(val);
        tail = head;
        size = 1;
    }

    public void offer(int val){
        ListNode newNode = new ListNode(val);
        if (tail == null) head = newNode;
        else tail.next = newNode;
        tail = newNode;
        size++;
    }

    public int getSize(){
        return size;
    }

    public int poll(){
        if (head == null) throw new IllegalArgumentException("");
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        size--;

        //list is empty, set tail to null
        if (getSize() == 0) tail = null;
        return temp.val;
    }

    public int peek(){
        if (head == null) throw new IllegalArgumentException("");
        return getSize() == 0 ? -1 : head.val;
    }

    public void printQueue(){
        if (head == null) return;
        ListNode curr = head;
        while (curr.next != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }


    public static void main(String[] args){
        MyQueueBySLL myQueue = new MyQueueBySLL(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.printQueue();
        System.out.println("poll: " + myQueue.poll());
        myQueue.printQueue();
        System.out.println("peek: " + myQueue.peek());
        System.out.println("size: " + myQueue.getSize());
        System.out.println("poll: " + myQueue.poll());
        System.out.println("poll: " + myQueue.poll());
        myQueue.printQueue();
        System.out.println(myQueue.getSize());
//        System.out.println(myQueue.peek());
    }

}
