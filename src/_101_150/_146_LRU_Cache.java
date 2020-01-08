package _101_150;

import java.util.HashMap;

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
    /**
     * double linked list
     * tail is the lastest one
     * When delete, usually delete the head
     */
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map;
    int capacity;

    public _146_LRU_Cache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node newest = map.get(key);
        disconnect(newest);
        insertToTail(newest);

        return newest.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node newest = new Node(key, value);
            map.put(key, newest);
            insertToTail(newest);

            if (map.size() == capacity) {
                /**
                 * map also need to remove the head.next
                 * !!! Here is why we need key.
                 */
                map.remove(head.next.key);
                disconnect(head.next);
            }
        } else {
            Node newest = map.get(key);
            newest.value = value;
            disconnect(newest);
            insertToTail(newest);
        }
    }

    private void insertToTail(Node node) {
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }

    private void disconnect(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = null;
        node.next = null;
    }

    private class Node {
        Node prev;
        Node next;

        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
}
