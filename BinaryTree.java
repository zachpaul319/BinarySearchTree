public interface BinaryTree<T> {
	public BinTreeNode<T> getRoot();
	public void setRoot(BinTreeNode<T> newRoot);
	public LinkedList<T> preorderTraversal();
	public LinkedList<T> inorderTraversal();
	public LinkedList<T> postorderTraversal();
	public String preorderString();
	public String inorderString();
	public String postorderString();
	public boolean isEmpty();
}
