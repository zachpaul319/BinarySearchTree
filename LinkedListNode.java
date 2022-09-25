public class LinkedListNode<T> {
	private T data;
	private LinkedListNode<T> next;

	public LinkedListNode() {
	}

	public LinkedListNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T newData) {
		data = newData;
	}

	public LinkedListNode<T> getNextNode() {
		return next;
	}

	public void setNextNode(LinkedListNode<T> newNext) {
		next = newNext;
	}
	
	public String toString() {
		String result = "";
		
		if (this.next == null) {
			result = this.data.toString();
		} else {
			result = this.data.toString() + " -> ";
		}
		
		return result;
	}
}
