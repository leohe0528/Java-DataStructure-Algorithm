package DesignDataStructure;

import java.util.List;

public class MyQueueByDLL {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyQueueByDLL(){
        head = tail = null;
        size = 0;
    }

    public MyQueueByDLL(int val){
        ListNode newNode = new ListNode(val);
        head = tail = newNode;
        size = 1;
    }

    public void offer(int val){
        ListNode newNode = new ListNode(val);
        if (tail == null) {
            tail = newNode;
            head = tail;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public int poll(){
        if (head == null) throw new IllegalArgumentException("");
        ListNode temp = head;
        if (head == tail){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
        return temp.val;
    }

    public int peek(){
        if (head == null) return -1;
        return head.val;
    }

    public int getSize(){
        return size;
    }

}
