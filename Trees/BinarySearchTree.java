package trees;

/**
 * ==========================================
 *  Generic Binary Search Tree Implementation in Java
 * ------------------------------------------
 *  Author: Stuti Pandey
 *  Date: February 23, 2025
 *  Description: 
 * ==========================================
 */

public class BinarySearchTree {
    class Node {
        int value;
        Node left;
        Node  right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    Node root;

    // Constructor
    BinarySearchTree () {
        root = null;
    }

    // Insert method
    void insert (int key) {
        root = insertRec(root, key);
    }

    Node insertRec (Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.value) {
            root.left = insertRec(root.left, key);
        } else {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // boolean search method
    boolean search(int key) {
        return searchNode(root, key) != null;
    }

    Node searchNode(Node root, int key) {
        if (root == null || root.value == key) {
            return root;
        }
        if (root.value > key) {
            return searchNode(root.left, key);
        } else {
            return searchNode(root.right, key);
        }
    }

    // delete
    void delete(int value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }
        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // first case: node with one or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get inorder successor (smallest in right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    int minValue(Node root) {
        int minVal = root.value;

        while (root.left != null) {
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    }

    // inorder
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.value + " ");
        inorder(root.right);
    }

    // preorder
    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // postorder
    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.value + " ");
    }

    // // level order traversal
    // public void levelOrder(Node root) {

    // }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("\nInorder Traversal");
        bst.inorder(bst.root);

        System.out.println("\nPreorder Traversal\n");
        bst.preorder(bst.root);

        System.out.println("\nPostorder Traversal");
        bst.postorder(bst.root);

        // Search
        System.out.println("Searching for 40: " + bst.search(40));
        System.out.println("Searching for 90: " + bst.search(90));

        // Delete node
        System.out.println("Deleting 40...");
        bst.delete(40);

        System.out.println("Inorder traversal after deletion:");
        bst.inorder(bst.root);

    }

 }
