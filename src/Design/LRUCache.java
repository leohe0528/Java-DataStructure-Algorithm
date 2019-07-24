package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class ListNode{
        public int val;
        public int key;
        public ListNode prev;
        public ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    class DoublyLinkedList{
        public ListNode head;
        public ListNode tail;
        public DoublyLinkedList(){
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        public void addFirst(ListNode node){
            node.next = head.next;
            node.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void remove(ListNode node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    public int capacity, count;
    public Map<Integer, ListNode> map;
    public DoublyLinkedList DDL;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.DDL = new DoublyLinkedList();
    }

    public int get(int key) {
        if (map.get(key) != null){
            ListNode node = map.get(key);
            int result = node.val;
            DDL.remove(node);
            DDL.addFirst(node);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            DDL.remove(node);
            DDL.addFirst(node);
        }else if(count < capacity){
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            count++;
            DDL.addFirst(node);
        }else{
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            map.remove(DDL.tail.prev.key);
            DDL.remove(DDL.tail.prev);
            DDL.addFirst(node);
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        cache.get(2);
        cache.put(3, 2);
        cache.get(2);
        cache.get(3);
        /*
        ["LRUCache","put","get","put","get","get"]
        [[1],[2,1],[2],[3,2],[2],[3]]
         */
    }
}
