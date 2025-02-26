package trees;

/**
 * ================================================
 *  Segment Tree Implementation in Java
 * -----------------------------------------------
 *  Author: Stuti Pandey
 *  Date: Feb 21, 2025
 *  Description: This implementation of a Segment Tree
 *  supports:
 *   - Efficient range sum queries
 *   - Point updates
 *   - O(n) construction time and O(log n) query/update
 * 
 * When a Java file is inside a folder (e.g., Trees), Java treats that folder as a package.
    If you compile without specifying a package, Java might not recognize the file properly
    so declared a package Trees.
 * ================================================
 */

public class SegmentTree {
    private int[] segTree;
    private int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        segTree = new int[n * 4]; // allocate memory for the tree, max size= 4
        build(arr, 0, 0, n-1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            segTree[node] = arr[start]; // Leaf node stores array value
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            // Store sum of left and right children
            segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2];
        }

    }

    public int rangeSum(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0; // Out of range, return identity value (0 for sum)
        }
        if (left <= start && end <= right) {
            return segTree[node]; // Completely inside range
        }
        int mid = (start + end) / 2;
        int leftSum = query(2 * node  + 1, start, mid, left, right);
        int rightSum = query(2 * node + 2, mid + 1, end, left, right);
        return leftSum + rightSum;
    }

    public void update(int index, int newValue) {
        updateHelper(0, 0, n-1, index, newValue);
    }

    private void updateHelper(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            segTree[node] = newValue; 
        } else {
            int mid = (start + end) / 2;
            if (index <= mid) {
                updateHelper(2 * node + 1, start, mid, index, newValue);
            } else {
                updateHelper(2 * node + 2, mid + 1, end, index, newValue);
            }
            segTree[node] = segTree[2 * node + 1] + segTree[2 * node + 2]; // Recalculate parent sum
        }
    }

    // Helper function to print the segment tree (for debugging)
    public void printTree() {
        for(int val: segTree) {
            System.out.println(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int[] arr = {1, 3, 5, 7, 9, 11};
        int[] arr = {2, 4, 7, 10, 12, 13};  

        SegmentTree segmentTree = new SegmentTree(arr);
        
        // Query sum of range [1,4]
        System.out.println("Sum of range [1,4] is " + segmentTree.rangeSum(1,4)); 

        // Update query
        // segmentTree.update(2,10);
        // System.out.println("Updated index 2 to 10");

        segmentTree.update(3,11);
        System.out.println("Updated index 3 to 11");

        // Query sum again
        System.out.println("Sum of range [1,4]: " + segmentTree.rangeSum(1, 4)); 
    }
}