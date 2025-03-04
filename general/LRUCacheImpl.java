package general;

import java.util.*;

// LRU Cache implementation using HashMap and 
public class LRUCacheImpl {

    // Node class to represent each entry in the cache
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Dummy head and tail nodes to avoid edge case handling
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Get value from cache and update it's position to most recently used
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Return -1 if key not found
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value; // Move accessed node to the front (most recently used)
    }

    // put a key-value pair in the cache
    public void put (int key, int value) {
        if (cache.containsKey(key)) {
            // If key exists, update its value and move it to the front
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // If key does not exist, create a new node
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);

            if (cache.size() > capacity) {
                removeLRUNode(); // Remove least recently used node if over capacity
            }
        }
    }

    // move node to the front (most recently used position)
    private void moveToHead(Node node) {
        removeNode(node);
        addToFront(node);
    }

    // Add a right node after the head
    private void addToFront (Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Add a node from the doubly linkedList
    private void removeNode (Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;   
    }

    // Remove the least recently used node (the node before tail) and update cache
    private void removeLRUNode () {
        Node lruNode = tail.prev;
        removeNode(lruNode);
        cache.remove(lruNode.key);
    }

    public static void main(String[] args) {

         // Create an LRU cache with capacity 2
        LRUCacheImpl lruCache = new LRUCacheImpl(2);

        // Performance test
        lruCache.put(1,10); // Cache: {1=10}
        lruCache.put(2,20); // Cache: {1=10, 2=20}
        System.out.println(lruCache.get(1));    // Returns 10, moves 1 to front (recently used)

        lruCache.put(3, 30); // Evicts key 2, Cache: {1=10, 3=30}
        System.out.println(lruCache.get(2)); // Returns -1 (2 is evicted)

        lruCache.put(4, 40); // Evicts key 1, Cache: {4=40, 3=30}
        System.out.println(lruCache.get(1)); // Returns -1 (1 is evicted)
        System.out.println(lruCache.get(3)); // Returns 30
        System.out.println(lruCache.get(4)); // Returns 40

    }
    
}

/**
 * Put(1,10) & Put(2,20) → Cache stores {1=10, 2=20}
    Get(1) → Returns 10, moves 1 to the front.
    Put(3,30) → Capacity exceeded, evicts LRU key 2.
    Get(2) → Returns -1 (since 2 was removed).
    Put(4,40) → Capacity exceeded, evicts LRU key 1.
    Get(1) → Returns -1 (since 1 was removed).
    Get(3), Get(4) → Returns 30 and 40 respectively.
 */
