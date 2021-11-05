package cs342a2;

public class Node {

	private Node next;
	private String element;
	private int count;

	/**
	 * Constructor.
	 */
	public Node(String element) {
		next = null;
		this.element = element;
		count = 0;
	}

	/**
	 * Set next.
	 */
	public void next(Node next) {
		this.next = next;
	}

	/**
	 * Get next.
	 */
	public Node next() {
		return next;
	}

	/**
	 * Get element of node.
	 */
	public String element() {
		return element;
	}

	/**
	 * Get the number of element.
	 */
	public int count() {
		return count;
	}

	/**
	 * Add the number of element.
	 */
	public void addCount() {
		count++;
	}

}
