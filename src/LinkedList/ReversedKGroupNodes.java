package LinkedList;

public class ReversedKGroupNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || getLength(head) < k){
            return head;
        }

        ListNode rightCurr = head;
        for (int i = 0; i < k; i++){
            rightCurr = rightCurr.next;
        }
        ListNode rightList = reverseKGroup(rightCurr, k);

        ListNode leftList = null;
        ListNode leftCurr = head;
        for (int i = 0; i < k; i++){
            ListNode temp = leftCurr.next;
            leftCurr.next = leftList;
            leftList = leftCurr;
            leftCurr = temp;
        }
        head.next = rightList;
        return leftList;
    }

    private int getLength(ListNode head){
        ListNode curr = head;
        int len = 0;
        while (curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = new ReversedKGroupNodes().reverseKGroup(head, 3);
    }
}
