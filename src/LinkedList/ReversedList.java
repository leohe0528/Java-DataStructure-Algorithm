package LinkedList;

import java.util.List;
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
public class ReversedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        // wall
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new ReversedList().reverseList(head);
    }

}
