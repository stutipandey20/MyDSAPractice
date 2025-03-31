package linkedLists;

/**
 * Author: Stuti Pandey
 * Date: March 31, 2025
 *
 * Description:
 * A simple implementation of a Doubly Linked List in Java.
 * This LinkedList supports insertion, deletion, and printing (forward & backward).
 */

public class DoublyLinkedList {
    
    // Node class for doubly linked list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    // Insert node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Delete node with a given value
    public void delete(int data) {
        Node temp = head;

        while(temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next; // deleting head
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }
    
    // Display list forward
    public void displayForward() {
        Node temp = head;
        System.out.println("Forward List:");
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display list in reverse
    public void displayBackward() {
        if (head == null) {
            return;
        }
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.println("Backward List:");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String args[]) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtBeginning(5);

        dll.displayForward();   // 5 10 20 30
        dll.displayBackward();  // 30 20 10 5

        dll.delete(20);
        dll.displayForward();   // 5 10 30
    }
}
