package leetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * Leetcode - 105: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder 
 * traversal of a binary tree and `inorder` is the inorder traversal, construct the binary tree.
 * 
 * Topics: Array, HashMap, Recursion, Divide & Conquer, Tree, Binary Tree
 * 
 * Author: Stuti Pandey
 * Date: March 16, 2025
 */

// Definition of TreeNode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode  right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ConstructBinaryTree {

    // Global variable to track current index in preorder array
    private int preorderIndex = 0;
    /**
     * Builds the binary tree from preorder and inorder traversal arrays.
     * @param preorder Array representing preorder traversal (Root → Left → Right)
     * @param inorder Array representing inorder traversal (Left → Root → Right)
     * @return Root of the reconstructed binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store inorder index positions for quick lookup
        Map<Integer, Integer> inorderMap = new HashMap<>();

        int len = inorder.length;

        // Populate the map with the inorder traversal indices
        for(int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, inorderMap, 0, len - 1);
    }

     /**
     * Recursive function to construct the binary tree
     * @param preorder The preorder traversal array
     * @param inorderMap HashMap to quickly find the index of values in inorder traversal
     * @param left Left boundary of the current subtree in inorder traversal
     * @param right Right boundary of the current subtree in inorder traversal
     * @return The root node of the constructed subtree
     */
    private TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int left, int right) {
        // Base case: If there are no elements to construct the tree
        if (left > right) {
            return null;
        }

        // Pick the next node from preorder traversal
        int current = preorder[preorderIndex++];    // Move to next element in preorder

        // Create the new tree node
        TreeNode root = new TreeNode(current);
        
        // If this is a leaf node (no children), return immediately
        if (left == right) {
            return root;
        }
        // Find the inorder index of the current node
        int inorderIndex = inorderMap.get(current);

        // Recursively build the left and right subtrees
        root.left = helper(preorder, inorderMap, left, inorderIndex - 1);
        root.right = helper(preorder, inorderMap, inorderIndex + 1, right);

        return root;
    }

    /**
     * Utility function to print the tree in **Level Order Format**
     * Example: [3,9,20,null,null,15,7]
     * @param root The root node of the binary tree
     */
    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                result.add("null");
                continue;
            }

            result.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }

        // Remove trailing nulls to match LeetCode output format
        while (result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        ConstructBinaryTree treeBuilder = new ConstructBinaryTree();

        // Test Case: Construct binary tree from preorder and inorder traversal
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Build the tree
        TreeNode root = treeBuilder.buildTree(preorder, inorder);

        System.out.println("Level Order Traversal of Constructed Tree:");
        treeBuilder.printLevelOrder(root);
    }
}

/**
 * Time & Space Complexity
✅ Time Complexity: O(N)
    Each node is processed once.
    HashMap lookups are O(1).
    Overall, we process N nodes → O(N).

✅ Space Complexity: O(N)
    O(N) for HashMap
    O(N) recursion stack (worst case: skewed tree).
 */