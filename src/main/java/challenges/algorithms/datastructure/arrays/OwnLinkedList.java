package challenges.algorithms.datastructure.arrays;

public class OwnLinkedList {

    Node head; // head of the list

    /* Linked list node */
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is by default initialized as null
        Node(int data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(String.format(" %d ", n.data));
            n = n.next;
        }
    }
}
