import java.util.Scanner;

/**
 * A class to represent a Linked List
 */
class LL {
    // Create a Scanner object to read input from the user
    Scanner sc = new Scanner(System.in);

    // Head of the linked list
    Node head;

    // Pointer to traverse the list
    Node ptr;

    // Previous pointer to traverse the list
    Node preptr;

    // Size of the linked list
    int size = 0;

    /**
     * A nested class to represent a Node in the linked list
     */
    class Node {
        String data;
        Node next;

        /**
         * Constructor to create a new Node with the given data
         * @param _data the data to be stored in the Node
         */
        public Node(String _data) {
            this.data = _data;
            this.next = null;
            size++; // increment the size of the linked list
        }
    }

    /**
     * Method to add a new node at the beginning of the linked list
     * @param data the data to be stored in the new node
     */
    public void addFirst(String data) {
        Node newnode = new Node(data);

        if (head == null) {
            head = newnode;
            return;
        }

        newnode.next = head;
        head = newnode;
    }

    /**
     * Method to add a new node at a specific position in the linked list
     * @param data the data to be stored in the new node
     */
    public void addMiddle(String data){
        Node newnode = new Node(data);
        System.out.println("Enter the position of the node to be inserted: ");
        int pos = sc.nextInt();
        if(head==null){
            head=newnode;
            return;
        }

        ptr = head;
        preptr = head;

        for(int i=0; i<pos-1 ; i++){
            ptr = ptr.next;
        }

        while (preptr.next!=ptr) {
            preptr = preptr.next;
        }

        newnode.next = ptr;
        preptr.next = newnode;
    }

    /**
     * Method to add a new node at the end of the linked list
     * @param data the data to be stored in the new node
     */
    public void addLast(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }

        ptr = head;

        while (ptr.next != null) {
            ptr = ptr.next;
        }

        ptr.next = newnode;
    }

    /**
     * Method to traverse the linked list and print its elements
     */
    public void traverseList() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        ptr = head;

        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("Null");
    }

    /**
     * Method to delete the first node in the linked list
     */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        head = head.next;
        size--;
    }

    /**
     * Method to delete a node at a specific position in the linked list
     */
    public void deleteMiddle(){
        System.out.println("Enter the position from where you want to remove the node");
        int pos = sc.nextInt();

        ptr=head;
        preptr=head;

        for(int i=0; i<pos;i++){
            ptr = ptr.next;
        }
        for(int j=0;j<pos-2;j++){
            preptr = preptr.next;
        }
        preptr.next = ptr;
    }

    /**
     * Method to delete the last node in the linked list
     */
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        ptr = head;
        preptr = head;

        while (ptr.next != null) {
            ptr = ptr.next;
        }

        while (preptr.next != ptr) {
            preptr = preptr.next;
        }

        preptr.next = null;
        size--;
    }

    /**
     * Method to get the size of the linked list
     */
    public void getSize() {
        System.out.println("Size : " + size);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      LL list = new LL();

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
        list.addMiddle("1");

        list.traverseList();
        list.getSize();
        list.addMiddle("2");

        list.traverseList();
        list.getSize();
        list.addMiddle("3");

        list.traverseList();
        list.getSize();
        list.addLast("a");

        list.traverseList();
        list.getSize();
        list.deleteFirst();

        list.traverseList();
        list.getSize();
        list.deleteMiddle();

        list.traverseList();
        list.getSize();
        list.deleteFirst();

        list.traverseList();
        list.getSize();
        list.deleteMiddle();

        list.traverseList();
        list.getSize();
        list.deleteLast();
        list.traverseList();
        list.getSize();
    }
}
