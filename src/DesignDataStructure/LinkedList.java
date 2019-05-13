package DesignDataStructure;

import java.util.List;

//Single Linkedlist
public class LinkedList {
    //fields
    private ListNode head;
    private int size;

    //methods
    public LinkedList(){
        head = null;
        size = 0;
    }

    //overloading: pass int val
    public LinkedList(int val){
        head = new ListNode(val);
        size = 0;
    }

    //overloading" pass array of nums
    public LinkedList(int[] nums){
        if (nums == null) throw new IllegalArgumentException("nums cannot be null");
        head = new ListNode(nums[0]);
        size++;
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++){
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
            size++;
        }
    }
    //！！！注意不能是while(curr!=null) 因为如果curr != null， 出来的curr是等于null，此时这个null是没有分配地址也就是和head的那个
    // list断开，就算 new ListNode(int val) 也不会和head的那个list续上
    public void add(int val){
        ListNode newNode = new ListNode(val);
        if (head == null) head = newNode;
        ListNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
        size++;
    }
    //注意这里delete需要一个dummy node和curr创造新的head和遍历，最后让head指向新的head
    public void delete(int index){
        if (index > size) throw new IllegalArgumentException("wrong index");
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (index > 0){
            curr = curr.next;
            index--;
        }
        curr.next = curr.next.next;
        head = dummy.next;
        size--;
    }

    public int getVal(int index){
        if (index > size) throw  new IllegalArgumentException("wrong index");
        ListNode curr = head;
        while (index > 0){
            curr = curr.next;
            index--;
        }
        return curr.val;
    }

    public int getSize(){
        return size;
    }

    public void printVal(){
        if (head == null) return;
        ListNode curr = head;
        while (curr.next != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }

    public static void main(String[] args){
        System.out.println("test case: initialize with nums array");
        int[] nums = new int[]{1, 2, 3, 4, 5};
        LinkedList list = new LinkedList(nums);
        list.printVal();

        System.out.println("test case: add value");
        list.add(10);
        list.printVal();

        System.out.println("test case: delete val");
        list.delete(0);
        list.printVal();

        System.out.println("test case get 0th val and 2th val");
        int zeroVal = list.getVal(0);
        int secVal = list.getVal(2);
        System.out.println("0th val: " + zeroVal + "; 2th val: " + secVal);

        System.out.print("size: " + list.getSize());
    }

}
