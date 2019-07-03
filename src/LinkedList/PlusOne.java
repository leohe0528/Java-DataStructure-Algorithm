package LinkedList;

public class PlusOne {
    public ListNode plusOne(ListNode head) {
        if( DFS(head) == 0){
            return head;
        }else{
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }

    public int DFS(ListNode head){
        if(head == null) return 1;

        int carry = DFS(head.next);

        if(carry == 0) return 0;

        int val = head.val + 1;
        head.val = val%10;
        return val/10;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(9);
        ListNode res = new PlusOne().plusOne(head);
    }
}
