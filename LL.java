/**
 * A class representing a singly linked list. It allows adding nodes
 * at the beginning and the end, deleting nodes from the beginning
 * and the end, printing the list, and retrieving the size of the list.
 */
class LL {

    // Reference to the first node (head) of the linked list
    Node head;  
    
    // Reference to the last node (tail) of the linked list
    Node tail;  
    
    // Keeps track of the number of nodes in the linked list
    int size = 0;  

    /**
     * A class representing a node in the linked list.
     * Each node contains data and a reference to the next node.
     */
    class Node {
        String data;  // Data stored in the node
        Node next;    // Reference to the next node in the linked list

        /**
         * Constructor to create a new node with the given data.
         * 
         * parameter _data The data to be stored in the node.
         */
        Node(String _data) {
            this.data = _data;  // Initialize the data of the node
            this.next = null;   // By default, next is set to null
            size++;  // Increase the size of the linked list when a node is created
        }
    }

    /**
     * Adds a node with the specified data at the beginning of the linked list.
     * 
     * parameter data The data to be stored in the new node.
     */
    public void addFirst(String data) {
        Node newnode = new Node(data);  // Create a new node with the provided data

        if (head == null) {
            System.out.println("Head -> Null");
            head = newnode;
            tail = newnode;  // Since it's the first node, head and tail point to the same node
            return;
        }

        newnode.next = head;  // Link the new node to the current head
        head = newnode;  // Update head to the new node
    }

    /**
     * Adds a node with the specified data at the end of the linked list.
     * 
     * parameter data The data to be stored in the new node.
     */
    public void addLast(String data) {
        Node newnode = new Node(data);  // Create a new node with the provided data

        if (head == null) {  // If the list is empty, initialize both head and tail
            System.out.println("Tail -> Null");
            head = newnode;
            tail = newnode;
            return;
        }

        tail.next = newnode;  // Link the current tail's next to the new node
        tail = newnode;  // Update tail to the new node
    }

    /**
     * Prints the linked list starting from the head.
     * Outputs the elements in the format: Head -> [data1] -> [data2] -> ... -> Null.
     */
    public void printList() {
        if (head == null) {
            System.out.println("The List is empty.");
            return;
        }

        Node currentNode = head;  // Start from the head of the list
        System.out.print("Head -> ");

        while (currentNode != null) {  // Traverse the list and print each node
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;  // Move to the next node
        }
        System.out.println("Null");  // Indicate the end of the list
    }

    /**
     * Deletes the first node (head) from the linked list.
     * If the list is empty, prints a message indicating so.
     */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The List is empty.");
            return;
        }

        head = head.next;  // Move head to the next node
        size--;  // Decrease the size of the list

        // If the list becomes empty, update tail to null
        if (head == null) {
            tail = null;
        }
    }

    /**
     * Deletes the last node (tail) from the linked list.
     * If the list is empty, prints a message indicating so.
     */
    public void deleteLast() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }

        size--;  // Decrease the size of the list

        // If there's only one node, set both head and tail to null
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }

        // Traverse to the second last node
        Node currNode = head;
        while (currNode.next != tail) {
            currNode = currNode.next;
        }

        // Update tail to the second last node and remove the last node
        tail = currNode;
        tail.next = null;
    }

    /**
     * Prints the size of the linked list.
     */
    public void getSize() {
        System.out.println("Size of the Linked list: " + size);
    }

    /**
     * Main method to test the functionality of the linked list class.
     * Demonstrates adding, deleting, and printing nodes in the linked list.
     * 
     */
    public static void main(String args[]) {
        LL list = new LL();  // Create a new linked list

        // Adding nodes to the front of the list
        list.addFirst("Linked List");
        list.printList();  // Print the current list
        list.getSize();  // Print the current size

        list.addFirst("a");
        list.printList();
        list.getSize();

        list.addFirst("is");
        list.printList();
        list.getSize();

        list.addFirst("This");
        list.printList();
        list.getSize();

        // Deleting nodes from the front of the list
        list.deleteFirst();
        list.printList();
        list.getSize();

        list.deleteFirst();
        list.printList();
        list.getSize();

        // Adding nodes to the end of the list
        list.addLast("new last");
        list.printList();
        list.getSize();

        // Deleting the last node
        list.deleteLast();
        list.printList();
        list.getSize();
    }
}
