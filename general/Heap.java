package general;

import java.util.ArrayList;

/**
 * Heap Data Structure (MinHeap & MaxHeap) Implementation in Java
 * 
 * MinHeap: The smallest element is at the root.
 * MaxHeap: The largest element is at the root.
 * 
 * Operations:
 * - insert(int val): Adds a new element.
 * - getMin() / getMax(): Retrieves the minimum or maximum element.
 * - extractMin() / extractMax(): Removes and returns the min or max element.
 * - heapifyUp(): Maintains heap property after insertion.
 * - heapifyDown(): Maintains heap property after deletion.
 * 
 * Time Complexity:
 * - Insert: O(log N)
 * - Extract Min/Max: O(log N)
 * - Get Min/Max: O(1)
 * 
 * Space Complexity: O(N) (stores N elements in an ArrayList)
 */

// MinHeap Implementation

class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Insert a new element => O(log n)
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1); // restore heap property
    }

    // get the minimum element (root)
    public int getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is Empty!");
        }
        return heap.get(0);
    }

    // Extract the min (remove the smallest element) => O(log n)
    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));    // Move last element to root
        heap.remove(heap.size() - 1); // remove the last element since it is no longer needed since we moved it to the top
        // now we need to heapify down so that the minimum element is at the top
        heapifyDown(0); // Restore heap property
        return min;
    } 

    // Heapify up (restore heap property after insertion)
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while(index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Heapify down (restore heap property after deletion)
    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;
        while(index < heap.size() / 2) { // While index has at least one child
            leftChild = 2 * index + 1;
            rightChild =  2 * index + 2;
            smallest = leftChild;

            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(leftChild)) {
                smallest = rightChild;
            }

            if (heap.get(index) <= heap.get(smallest)) {
                break;  // Heap property satisfied
            }
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // print the heap elements
    public void printHeap() {
        System.out.println(heap);
    }
}

// Max Heap Implementation
class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Insert a new element
    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    // get max element - root value
    public int getMax() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    // extract the root element - the larget value in the heap
    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return max;
    }

    // Heapify Up (restore heap property after insertion)
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Heapify Down (restore heap property after deletion)
    private void heapifyDown(int index) {
        int leftChild, rightChild, largest;

        while (index < heap.size() / 2) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            largest = leftChild;

            if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
                largest = rightChild;
            }

            if (heap.get(index) >= heap.get(largest)) {
                break;
            }
            swap(index, largest);
            index = largest;
        }

    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Display heap elements
    public void printHeap() {
        System.out.println(heap);
    }
}
// Main Class to Test MinHeap and MaxHeap
public class Heap {
    public static void main(String[] args) {
        // Example 1: MinHeap Test
        System.out.println("\nMinHeap Example:");
        MinHeap minHeap = new MinHeap();
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(17);
        minHeap.insert(8);
        minHeap.insert(25);
        minHeap.printHeap();
        System.out.println("Min element: " + minHeap.getMin());
        System.out.println("Extract Min: " + minHeap.extractMin());
        minHeap.printHeap();

        // Add separator for readability
        System.out.println("=========================");

        // Example 2: MaxHeap Test
        System.out.println("\nMaxHeap Example:");
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(15);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(17);
        maxHeap.insert(8);
        maxHeap.insert(25);
        maxHeap.printHeap();
        System.out.println("Max element: " + maxHeap.getMax());
        System.out.println("Extract Max: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}


