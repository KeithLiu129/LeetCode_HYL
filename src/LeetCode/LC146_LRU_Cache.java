package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC146_LRU_Cache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    int capacity;

    public LC146_LRU_Cache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }else {
            Node tmp = map.get(key);
            remove(key);
            addHead(key, tmp.val);
            return map.get(key).val;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
        }
        addHead(key, value);
    }

    private void remove(int key) {
        Node node = map.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(key);
        size--;
    }

    private void addHead(int key, int val) {
        Node node = new Node(key, val);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.prev = next;
        next.prev = node;
        map.put(key, node);
        size ++;
        if (size > capacity) {
            Node newTail = tail.prev;
            remove(newTail.key);
        }
    }
}
