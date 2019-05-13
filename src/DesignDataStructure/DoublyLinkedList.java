package DesignDataStructure;

public class DoublyLinkedList {
    //feilds
    private ListNode head;
    private ListNode tail;
    private int size;

    //methods

    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public DoublyLinkedList(int val){
        ListNode newNode = new ListNode(val);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void addHead(int val){
        ListNode newNode = new ListNode(val);

        if (head == null) tail = newNode;
        else{
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void addTail(int val){
        ListNode newNode = new ListNode(val);

        if (tail == null) head = newNode;
        else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public int getVal(int index){
        if (head == null || index < 0 || index > size) throw new IllegalArgumentException("index is greater than the size of linkedlist");
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

    public void printValFromHead(){
        if (head == null) return;
        ListNode curr = head;
        while (curr.next != null){
            System.out.print(curr.val + " => ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }

    public void printValFromTail(){
        if (head == null) return;
        ListNode curr = tail;
        while (curr.prev != null){
            System.out.print(curr.val + " => ");
            curr = curr.prev;
        }
        System.out.println(curr.val);
    }


    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList(1);
        list.addHead(2);
        list.addTail(3);
        list.printValFromHead();
        list.printValFromTail();
        System.out.println("size: " + list.getSize());
        System.out.println("0th val: " + list.getVal(0));
        System.out.println("1th val: " + list.getVal(2));

    }
}
