package DesignDataStructure;

public class MyStackBySLL {
    //fields
    private ListNode head;
    private int size;

    //methods: constructor, push, pop, peek
    //可以 head == tail == null吗？可以，先tail == null => head == tail
    public MyStackBySLL(){
        head = null;
        size = 0;
    }

    //overloading
    public MyStackBySLL(int val){
        head = new ListNode(val);
        size = 1;
    }

    public void push(int val){
        ListNode newNode = new ListNode(val);
        if (head != null) newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop(){
        if (head == null) throw new IllegalArgumentException("");
        ListNode temp = head;
        head = temp.next;
        temp.next = null;
        size--;
        return temp.val;
    }

    public int peek(){
        return head == null ? -1 : head.val;
    }

    public int getSize(){
        return size == 0 ? 0 : size;
    }

    public void printStack(){
        if (head == null) throw new IllegalArgumentException("");
        ListNode curr = head;
        while (curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void main(String[] args){
        MyStackBySLL myStack = new MyStackBySLL();
        for (int i = 0; i < 5; i++){
            myStack.push(i);
        }
        myStack.printStack();

        System.out.println("pop(): " + myStack.pop());
        System.out.println("Stack after poping once: ");
        myStack.printStack();

        System.out.println("peek(): " + myStack.peek());
        System.out.println("Stack after peek once: ");
        myStack.printStack();

    }

}
