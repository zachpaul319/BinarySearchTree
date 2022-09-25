public class BinTreeNode<T> {
	private T data;
	private BinTreeNode<T> leftChild, rightChild;
	
	public BinTreeNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData) {
		data = newData;
	}
	
	public BinTreeNode<T> getLeftChild() {
		return leftChild;
	}
	
	public void setLeftChild(BinTreeNode<T> left) {
		leftChild = left;
	}
	
	public boolean hasLeftChild() {
		return (getLeftChild() != null);
	}
	
	public BinTreeNode<T> getRightChild() {
		return rightChild;
	}
	
	public void setRightChild(BinTreeNode<T> right) {
		rightChild = right;
	}
	
	public boolean hasRightChild() {
		return (getRightChild() != null);
	}
	
	public boolean hasTwoChildren() {
		return (hasLeftChild() && hasRightChild());
	}
	
	public boolean isLeaf() {
		return (leftChild == null && rightChild == null);
	}
	
	public String toString() {
		return data.toString();
	}
}
