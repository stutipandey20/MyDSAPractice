package leetCode;
import java.util.*;

/**
 * Leetcode - 106: Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given two integer arrays `inorder` and `postorder` where `inorder` is the inorder 
 * traversal of a binary tree and `postorder` is the postorder traversal, construct the binary tree.
 * 
 * Topics: Array, HashMap, Recursion, Divide & Conquer, Tree, Binary Tree
 * 
 * Author: Stuti Pandey
 * Date: March 16, 2025
 */

// Definition of TreeNode - present in LC 105
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode  right;

//     TreeNode(int val) {
//         this.val = val;
//         this.left = null;
//         this.right = null;
//     }
// }

public class ConstructBinaryTreePostorder {
    
    // global variable to track current index in postorder array
    private int postIndex;

    /**
     * Builds the binary tree from inorder and postorder traversal arrays.
     * @param inorder Array representing inorder traversal (Left → Root → Right)
     * @param postorder Array representing postorder traversal (Left → Right → Root)
     * @return Root of the reconstructed binary tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Map to store inorder index positions for quick lookup
        Map<Integer, Integer> inorderMap = new HashMap<>();

        // Populate the map with the inorder traversal indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Start from the last index of postorder (Root of entire tree)
        postIndex = postorder.length - 1;

        // Start the recursive construction
        return helper(postorder, inorderMap, 0, inorder.length - 1);
    }

    /**
     * Recursive function to construct the binary tree
     * @param postorder The postorder traversal array
     * @param inorderMap HashMap to quickly find the index of values in inorder traversal
     * @param left Left boundary of the current subtree in inorder traversal
     * @param right Right boundary of the current subtree in inorder traversal
     * @return The root node of the constructed subtree
     */
    private TreeNode helper(int[] postorder, Map<Integer, Integer> inorderMap, int left, int right) {
        // Base case there are no elements to construct the tree
        if (left > right) {
            return null;
        }

        // Pick the current root from postorder traversal (postIndex starts from end)
        int currentVal = postorder[postIndex--];
        TreeNode root = new TreeNode(currentVal);

        // If this is a leaf node (no children), return immediately
        if (left == right) {
            return root;
        }

        // Get the inorder index of the current node
        int inorderIndex = inorderMap.get(currentVal);

        // Recursively build right and left subtrees (Right first because postorder is L-R-Root)
        root.right = helper(postorder, inorderMap, inorderIndex + 1, right);
        root.left = helper(postorder, inorderMap, left, inorderIndex - 1);

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
        List<String> result = new LinkedList<>();

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
        while(result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }
        System.out.println(result);
    }
    /**
     * Main function to test the implementation
     */
    public static void main(String[] args) {
        ConstructBinaryTreePostorder binaryTreePostorder = new ConstructBinaryTreePostorder();

        // Test Case: Construct binary tree from inorder and postorder traversal
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // Build the tree
        TreeNode root = binaryTreePostorder.buildTree(inorder, postorder);

        // Print the tree in Level-Order format
        System.out.println("Level-Order Representation of Constructed Tree:");
        binaryTreePostorder.printLevelOrder(root);

    }
}
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */