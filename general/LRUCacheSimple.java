package general;
import java.util.*;

public class LRUCacheSimple {
    
    // Hash map to store the cache data
	// key as Integer and Value as String
    HashMap<Integer, String> data = new HashMap<Integer, String>();
    // Linked list to store the order of cache access
    LinkedList<Integer> order = new LinkedList<>();
    // capacity of the Cache
    int capacity;

    LRUCacheSimple(int capacity) {
        this.capacity = capacity;
    }

    // put - for adding new cache
    public void put (int key, String value) {
        // check if the cache is already full
        if (order.size() >= capacity) {
            // if the cache is full, then remove the last element from the order list and
			// also from the data
			// so we will get room for new cache
            int keyRemoved = order.removeLast(); // remove from order
			data.remove(keyRemoved);// remove from data
        }
        // add the new cache to top of the list and also to data
		order.addFirst(key);// add to top of the list
		data.put(key, value);// add to data
    }

    // get a value from the cache
    String get (int key) {
        String res = data.get(key); //get the value from map using the key
        if (res != null) {
            //if the data is present then we need to update the access order
			//move the current key to top of the access list
			//to move to top of the list first remove it and re-add it
            order.remove((Object) key);
            order.addFirst(key);
        } else {
            res = null;
        }
        return res;
    }

    // display method
    public void display () {
        for (int i = 0; i < order.size(); i++) {
            int key = order.get(i);
            System.out.println(key + " => " + data.get(key));
        }
    }

    public static void main (String[] args) {
        LRUCacheSimple cache = new LRUCacheSimple(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.display();
        cache.put(4, "four"); // putting new cache when full. 1 will be removed
        cache.display();

        cache.get(3); // accessing 3, it will be moved to top
		cache.get(2);// accessing 2, it will be moved to top
        cache.display();

        cache.put(1, "one"); // putting new cache when full. 4 will be removed
		cache.get(3);// accessing 3, it will be moved to top
		cache.get(1);// accessing 1, it will be moved to top
		cache.display(); // 1 should be on top
    }

}
