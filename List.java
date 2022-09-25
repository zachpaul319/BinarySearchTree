public interface List<T> {
	public T getFirst();
	public LinkedListNode<T> getFirstNode();
	public T getLast();
	public void insertFirst(T data);
	public void insertAfter(LinkedListNode<T> currentNode, T data);
	public void insertLast(T data);
	public void deleteFirst();
	public void deleteLast();
	public void deleteNext(LinkedListNode<T> currentNode);
	public int size();
	public boolean isEmpty();
}
