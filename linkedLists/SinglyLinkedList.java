package linkedLists;

/**
 * Author: Stuti Pandey
 * Date: March 13, 2025
 *
 * Description:
 * A simple implementation of a Singly Linked List in Java.
 * This LinkedList supports insertion, deletion, searching, and printing.
 */

public class SinglyLinkedList {
    
    // Node class representing each element in the LinkedList
    static class Node {
        int data;
        Node next;

        // Constructor to initialize node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the LinkedList
    private Node head;
    private int size; // To track the size of the list

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
        size = 0;
    }

    /** 
     * Add a node at the beginning of the list.
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;    // New node points to old head
        head = newNode;     // Update head
        size++;
    }

    /** 
     * Add a node at the end of the list.
     */
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    /**
     * Remove the node from the beginning of the list.
     */
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        } else {
            head = head.next;
            size--;
        }
    }

    /**
     * Remove the node from the end of the list.
     */
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        } else {
            if (head.next == null) {
                head = null;
            } else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
                size--;
            }
        }
    }

    /** 
     * Search for a value in the list.
     * @return true if found, false otherwise.
     */
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /** 
     * Print all elements in the list.
     */
    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /** 
     * Get the size of the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Main method for testing the linked list operations.
     */
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);
        list.addFirst(5);
        list.addLast(20);
        list.addLast(30);

        System.out.println("Linked List after insertions:");
        list.printList(); // Output: 5 -> 10 -> 20 -> 30 -> null

        System.out.println("Size of list: " + list.size());

        list.removeFirst();
        System.out.println("\nAfter removing first element:");
        list.printList(); // Output: 10 -> 20 -> 30 -> null

        list.removeLast();
        System.out.println("\nAfter removing last element:");
        list.printList(); // Output: 10 -> 20 -> null

        System.out.println("\nSearching for 20: " + list.search(20)); // Output: true
        System.out.println("Searching for 40: " + list.search(40)); // Output: false
    }
}
