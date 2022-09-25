public interface BinSearchTree<T> {
	public void insert(T data);
	public BinTreeNode<T> search(T data);
	public T minElement();
	public T maxElement();
}
