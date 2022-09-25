public class DefaultBinaryTree<T> implements BinaryTree<T> {
	protected BinTreeNode<T> root;
	private BinTreeNode<T> rootLeft, rootRight;

	public DefaultBinaryTree() {
	}

	public BinTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinTreeNode<T> newRoot) {
		root = newRoot;
	}

	private LinkedList<T> preorderTraversal(BinTreeNode<T> node, LinkedList<T> preTraversal) {
		if (node != null) {
			preTraversal.insertLast(node.getData());
			preorderTraversal(node.getLeftChild(), preTraversal);
			preorderTraversal(node.getRightChild(), preTraversal);
		}

		return preTraversal;
	}

	public LinkedList<T> preorderTraversal() {
		LinkedList<T> preTraversal = new LinkedList<T>();
		return preorderTraversal(root, preTraversal);
	}

	public String preorderString() {
		return this.preorderTraversal().toString();
	}

	private LinkedList<T> inorderTraversal(BinTreeNode<T> node, LinkedList<T> inTraversal) {
		if (node != null) {
			inorderTraversal(node.getLeftChild(), inTraversal);
			inTraversal.insertLast(node.getData());
			inorderTraversal(node.getRightChild(), inTraversal);
		}

		return inTraversal;
	}

	public LinkedList<T> inorderTraversal() {
		LinkedList<T> inTraversal = new LinkedList<T>();
		return inorderTraversal(root, inTraversal);
	}

	public String inorderString() {
		return this.inorderTraversal().toString();
	}

	private LinkedList<T> postorderTraversal(BinTreeNode<T> node, LinkedList<T> postTraversal) {
		if (node != null) {
			postorderTraversal(node.getLeftChild(), postTraversal);
			postorderTraversal(node.getRightChild(), postTraversal);
			postTraversal.insertLast(node.getData());
		}

		return postTraversal;
	}

	public LinkedList<T> postorderTraversal() {
		LinkedList<T> postTraversal = new LinkedList<T>();
		return postorderTraversal(root, postTraversal);
	}

	public String postorderString() {
		return this.postorderTraversal().toString();
	}

	private int countNonLeaves(BinTreeNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			if (node.hasTwoChildren()) {
				return (1 + countNonLeaves(node.getLeftChild()) + countNonLeaves(node.getRightChild()));
			} else if (node.hasLeftChild()) {
				return (1 + countNonLeaves(node.getLeftChild()));
			} else if (node.hasRightChild()) {
				return (1 + countNonLeaves(node.getRightChild()));
			} else {
				return 0;
			}
		}
	}

	public int countNonLeaves() {
		return (countNonLeaves(root));
	}

	protected DefaultBinaryTree<T> leftSubTreeWithRoot() {
		rootRight = root.getRightChild();
		this.getRoot().setRightChild(null);
		return this;
	}

	protected void restoreRightSubTree() {
		this.getRoot().setRightChild(rootRight);
	}

	protected DefaultBinaryTree<T> rightSubTreeWithRoot() {
		rootLeft = root.getLeftChild();
		this.getRoot().setLeftChild(null);
		return this;
	}

	protected void restoreLeftSubTree() {
		this.getRoot().setLeftChild(rootLeft);
	}

	private int getHeight(BinTreeNode<T> node) {
		if (node == null || node.isLeaf()) {
			return 0;
		} else if (!(node.hasTwoChildren())) {
			return countNonLeaves();
		} else {
			int leftHeight = leftSubTreeWithRoot().countNonLeaves();
			restoreRightSubTree();
			
			int rightHeight = rightSubTreeWithRoot().countNonLeaves();
			restoreLeftSubTree();
			
			if (leftHeight > rightHeight) {
				return leftHeight;
			} else {
				return rightHeight;
			}
		}
	}
	
	public int getHeight() {
		return getHeight(root);
	}

	public boolean isEmpty() {
		return (root == null);
	}
}
