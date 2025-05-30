package trees.BT;

/**
 * ==========================================
 *  Generic Binary Tree Implementation in Java
 * ------------------------------------------
 *  Author: Stuti Pandey
 *  Date: February 21, 2025
 *  Description: This implementation of a Binary Tree supports:
 *   - Level-order insertion (Not a BST)
 *   - Inorder, Preorder, and Postorder Traversals
 *   - Tree Height Calculation
 *   - Level Order Traversal
 * ==========================================
 */

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // to insert the value in a Binary Tree

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // If left child is missing, insert here
            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            // If right child is missing, insert here
            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }

        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.value + " ");
        inOrder(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value + " ");
    }

    /*
     * Level Order Traversal (Breadth-First Traversal)
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.value + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    /*
     * height of a Binary Tree
     */
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        int[] elements = {10, 20, 30, 40, 50, 60, 70};

        for(int node : elements) {
            binaryTree.insert(node);
        }

        // Performing traversals
        System.out.println("Inorder Traversal\n");
        binaryTree.inOrder(binaryTree.root);

        System.out.println("Preorder Traversal\n");
        binaryTree.preOrder(binaryTree.root);

        System.out.println("Postorder Traversal\n");
        binaryTree.postOrder(binaryTree.root);

        System.out.println("Level Order Traversal\n");
        binaryTree.levelOrder(binaryTree.root);

        // Tree Height
        System.out.println("\nHeight of the tree: " + binaryTree.height(binaryTree.root));

    }
}
