package challenges.algorithms.datastructure.arrays;

public class UsingOwnLinkedListExampleMain {

    public static void main(String[] args) {
        OwnLinkedList linkedListOwn = new OwnLinkedList();
        linkedListOwn.head = new OwnLinkedList.Node(1);
        OwnLinkedList.Node second = new OwnLinkedList.Node(2);
        OwnLinkedList.Node third = new OwnLinkedList.Node(3);

        linkedListOwn.head.next = second;
        second.next = third;

        linkedListOwn.printList();
    }
}
