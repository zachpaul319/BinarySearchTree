public class LinkedList<T> implements List<T>{
	private LinkedListNode<T> head;

	public LinkedList() {
	}

	public T getFirst() {
		return head.getData();
	}

	public LinkedListNode<T> getFirstNode() {
		return head;
	}

	public T getLast() {
		LinkedListNode<T> tail = head;
		while (tail.getNextNode() != null) {
			tail = tail.getNextNode();
		}

		return tail.getData();
	}

	public void insertFirst(T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		newNode.setNextNode(head);
		head = newNode;
	}

	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		newNode.setNextNode(currentNode.getNextNode());
		currentNode.setNextNode(newNode);
	}

	public void insertLast(T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);

		if (isEmpty()) {
			head = newNode;
		} else {
			LinkedListNode<T> last = head;
			while (last.getNextNode() != null) {
				last = last.getNextNode();
			}

			last.setNextNode(newNode);
		}
	}

	public void deleteFirst() {
		head = head.getNextNode();
	}

	public void deleteLast() {
		if (head.getNextNode() == null) {
			head = null;
		} else {
			LinkedListNode<T> secondLast = head;
			while (secondLast.getNextNode().getNextNode() != null) {
				secondLast = secondLast.getNextNode();
			}

			secondLast.setNextNode(null);
		}
	}

	public void deleteNext(LinkedListNode<T> currentNode) {
		if (head.getNextNode() == null) {
			head = null;
		} else {
			currentNode.setNextNode(currentNode.getNextNode().getNextNode());
		}
	}

	public int size() {
		LinkedListNode<T> temp = head;

		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.getNextNode();
		}

		return size;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public String toString() {
		String result = "";

		LinkedListNode<T> node = head;
		while (node != null) {
			String nodeString = node.toString();
			result += nodeString;
			node = node.getNextNode();
		}

		return result;
	}
}
