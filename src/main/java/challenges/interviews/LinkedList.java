package challenges.interviews;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedList {

	static class Node {
		String data;
		Node next;
		
		Node(String elementNew){
			data = elementNew;
			next = null;
		}
	}
	
	static public Boolean detectLoop(Node node) {
		Set<Node> nodes = new HashSet<>();
		while(Objects.nonNull(node)) {
			if(nodes.contains(node)) {
				return Boolean.TRUE;
			}
			nodes.add(node);
			node = node.next;
		}
		
		return Boolean.FALSE;
	}
	
	@Test
	public void testThatDetectLoopInLinkedList() {
		Node node1 = new Node("A");
		Node node2 = new Node("B");
		Node node3 = new Node("C");
		Node node4 = new Node("D");
		Node node5 = new Node("E");
		Node node6 = new Node("F");
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;
		
		Boolean isThereLoop = LinkedList.detectLoop(node1);
		assertTrue(isThereLoop);
	}
	
	@Test
	public void testThatDetectNotLoopInLinkedList() {
		Node node1 = new Node("A");
		Node node2 = new Node("B");
		Node node3 = new Node("C");
		Node node4 = new Node("D");
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		Boolean isThereLoop = LinkedList.detectLoop(node1);
		assertFalse(isThereLoop);
	}
}
