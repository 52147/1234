package cs342a2;

public class LinkedList {

	private Node head;
	private int length;

	public LinkedList() {
		head = null;
		length = 0;
	}
	
	/**
	 * Get the head node.
	 */
	public Node head() {
		return head;
	}
	
	/**
	 * Get the length of linked list.
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * Check whether the linked list is empty.
	 */
	public boolean isEmpty() {
		return (head == null);
	}
	
	/**
	 * Insert the node at the head.
	 */
	public void insertNode(String element) {
		if (isEmpty()) {
			head = new Node(element);
			head.addCount();
			length++;
			return;
		}

		Node current = head;
		boolean isEqual = true;

		while (!current.element().equals(element)) {
			if (current.next() == null) {
				isEqual = false;
				break;
			} else
				current = current.next();
		}

		if (isEqual) {
			current.addCount();
		} else {
			current.next(new Node(element));
			current.next().addCount();
			length++;
		}
	}
}
