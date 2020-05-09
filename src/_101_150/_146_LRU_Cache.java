package _101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * LRUCache cache = new LRUCache(2)
 * <p>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */

public class _146_LRU_Cache {
    public static void main(String[] args) {
        _146_LRU_Cache cache = new _146_LRU_Cache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // returns 1
        System.out.println(cache.get(1));
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }

    Map<Integer, Node> map;
    DoubleList dList;
    int cap;

    public _146_LRU_Cache(int capacity) {
        map = new HashMap<>();
        dList = new DoubleList();
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // map contains it. So need to get the val. Then move the order to be last.
        Node node = map.get(key);
        dList.moveToFirst(node);
        return node.val;
    }

    // When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
    // so need to delete one item
    // change map first. Then change order to be first
    public void put(int key, int value) {
        // no need to care capactiy
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            dList.moveToFirst(node);
            return;
        }

        // need to care capacity since add
        if (map.size() == cap) {
            // map also need remove the last node key in map
            Node last = dList.removeLast();
            map.remove(last.key);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        dList.addFirst(node);
    }

    public class DoubleList {
        // int size;
        Node head, tail;

        //<identifier> expected [in DoubleList.java]. Need ()
        public DoubleList() {
            // size = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void moveToFirst(Node x) {
            remove(x);
            addFirst(x);
        }

        // add to top
        public void addFirst(Node x) {
            // size++;

            x.next = head.next;
            x.prev = head;

            head.next.prev = x;
            head.next = x;
        }

        // must exist
        public Node remove(Node x) {
            // size--;

            // always has prev and next != null
            x.prev.next = x.next;
            x.next.prev = x.prev;

            x.prev = null;
            x.next = null;
            return x;
        }

        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }

            Node x = tail.prev;
            return remove(x);
        }

        // public int size() {
        //     return size;
        // }
    }

    public class Node {
        int val;
        int key;

        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
