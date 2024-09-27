import java.util.Scanner;

/**
 * This class represents a singly linked list (LL) structure.
 * It allows adding elements to the front and back of the list,
 * deleting the first and last elements, and traversing the list.
 */
class LL {
    Node head; // Pointer to the head (first) node of the linked list
    Node ptr; // Pointer used for traversing the list
    Node preptr; // Pointer used to store the previous node during traversal

    int size = 0; // Keeps track of the size of the list

    /**
     * This class represents a single node of the linked list.
     */
    class Node {
        String data; // Data to store in the node
        Node next; // Pointer to the next node in the list

        /**
         * Constructor to create a new node with given data.
         * @param _data The data to be stored in the node
         */
        public Node(String _data) {
            this.data = _data;
            this.next = null;
            size++; // Increase size when a new node is created
        }
    }

    /**
     * Adds a new node with the given data at the front of the list.
     * @param data The data to be added to the list
     */
    public void addFirst(String data) {
        Node newnode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newnode;
            return;
        }

        // New node points to the current head and becomes the new head
        newnode.next = head;
        head = newnode;
    }

    /**
     * Adds a new node with the given data at the end of the list.
     * @param data The data to be added to the list
     */
    public void addLast(String data) {
        Node newnode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newnode;
            return;
        }

        // Traverse the list to find the last node
        ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }

        // Append the new node at the end of the list
        ptr.next = newnode;
    }

    /**
     * Traverses the list and prints each node's data.
     */
    public void traverseList() {
        // If the list is empty, display a message
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        // Start from the head and print each node's data
        ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("Null"); // Indicate the end of the list
    }

    /**
     * Deletes the first node (head) of the list.
     */
    public void deleteFirst() {
        // If the list is empty, display a message
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        // Move the head pointer to the next node
        head = head.next;
        size--; // Decrease the size as the first node is deleted
    }

    /**
     * Deletes the last node of the list.
     */
    public void deleteLast() {
        // If the list is empty, display a message
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        ptr = head;
        preptr = head;

        // Traverse the list to find the last node
        while (ptr.next != null) {
            ptr = ptr.next;
        }

        // Traverse again to find the second last node
        while (preptr.next != ptr) {
            preptr = preptr.next;
        }

        // Disconnect the last node
        preptr.next = null;
        size--; // Decrease the size as the last node is deleted
    }

    /**
     * Prints the size of the list.
     */
    public void getSize() {
        System.out.println("Size : " + size);
    }

    /**
     * The main method to test the linked list operations.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an empty linked list
        LL list = new LL();

        // Perform various operations on the linked list
        list.traverseList();
        list.getSize();
        list.addFirst("d");

        list.traverseList();
        list.getSize();
        list.addFirst("c");

        list.traverseList();
        list.getSize();
        list.addFirst("b");

        list.traverseList();
        list.getSize();
        list.addLast("a");

        list.traverseList();
        list.getSize();
        list.deleteFirst();

        list.traverseList();
        list.getSize();
        list.deleteLast();
        list.traverseList();
        list.getSize();
    }
}
