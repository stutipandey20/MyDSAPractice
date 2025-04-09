package general;
import java.util.*;

/**
 * Implementation of LFU Cache - Least Frequently Used
 * 
 * Based on frequency of access.
 * If there’s a tie, evict the Least Recently Used among them.
 * => We need to track both frequency and recency
 * 
 * @author Stuti Pandey
 * @date April 8, 2025
 */

public class LFUCache {
    
    // Node to store key, value, frequency
    private class Node {
        int key, value, freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // initial frequency
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> cache;     // key -> node
    private final Map<Integer, LinkedHashSet<Integer>> freqMap; // freq -> set of keys
    private final Map<Integer, Integer> keyToFreq; // key -> freq

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.keyToFreq = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        // Get value and update frequency
        Node node = cache.get(key);
        updateFrequency(key, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            // Update value and frequency
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(key, node);
        } else {
            // evict if capacity reached
            if (cache.size() >= capacity) {
                evictLFU();
            }

            // Insert new key
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            keyToFreq.put(key, 1);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }

    // Increase frequency of accessed key
    private void updateFrequency(int key, Node node) {
        int oldFreq = node.freq;
        node.freq++;

        // remove from old frequency list
        freqMap.get(oldFreq).remove(key);
        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }

        // Add to new frequency list
        freqMap.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(key);
        keyToFreq.put(key, node.freq);
    }

    // Evict least frequently used and least recently used key
    private void evictLFU() {
        // Get the keys with the current minFreq
        LinkedHashSet<Integer> keySet = freqMap.get(minFreq);
        int evictKey = keySet.iterator().next(); // Least Recently Used
        keySet.remove(evictKey);

        if(keySet.isEmpty()) {
            freqMap.remove(minFreq);
        }

        cache.remove(evictKey);
        keyToFreq.remove(evictKey);
    
    }

    // Test driver
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // Returns 10

        cache.put(3, 30); // Evicts key 2 (LFU)
        System.out.println(cache.get(2));   // Returns -1 (evicted)
        System.out.println(cache.get(3));   // Returns 30

        cache.put(4, 40);   // Evicts key 1 (LFU)
        System.out.println(cache.get(1));   // Returns -1 (evicted)
        System.out.println(cache.get(3)); // Returns 30
        System.out.println(cache.get(4)); // Returns 40

    }
}
