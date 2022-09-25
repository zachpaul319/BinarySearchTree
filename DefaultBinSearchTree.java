public class DefaultBinSearchTree<T extends Comparable<T>> extends DefaultBinaryTree<T> implements BinSearchTree<T> {
	public DefaultBinSearchTree() {
	}

	private void insert(T data, BinTreeNode<T> node) {
		if (this.isEmpty()) {
			this.setRoot(new BinTreeNode<T>(data));
		} else {
			if (data.compareTo(node.getData()) < 0) {
				if (node.getLeftChild() == null) {
					node.setLeftChild(new BinTreeNode<T>(data));
				} else {
					insert(data, node.getLeftChild());
				}
			} else {
				if (node.getRightChild() == null) {
					node.setRightChild(new BinTreeNode<T>(data));
				} else {
					insert(data, node.getRightChild());
				}
			}
		}
	}

	public void insert(T data) {
		insert(data, root);
	}

	private BinTreeNode<T> search(T data, BinTreeNode<T> node) {
		if (node == null) {
			return null;
		} else {
			if (data.compareTo(node.getData()) == 0) {
				return node;
			} else {
				if (data.compareTo(node.getData()) < 0) {
					return search(data, node.getLeftChild());
				} else {
					return search(data, node.getRightChild());
				}
			}
		}
	}

	public BinTreeNode<T> search(T data) {
		return search(data, root);
	}

	private T minElement(BinTreeNode<T> node) {
		if (node.getLeftChild() == null) {
			return node.getData();
		} else {
			return minElement(node.getLeftChild());
		}
	}

	public T minElement() {
		return minElement(root);
	}

	private T maxElement(BinTreeNode<T> node) {
		if (node.getRightChild() == null) {
			return node.getData();
		} else {
			return maxElement(node.getRightChild());
		}
	}

	public T maxElement() {
		return maxElement(root);
	}

	public BinTreeNode<T> predecessor(BinTreeNode<T> node) {
		LinkedList<T> traversal = this.inorderTraversal();

		LinkedListNode<T> key = traversal.getFirstNode();
		while (key.getNextNode().getData() != node.getData()) {
			key = key.getNextNode();
		}

		BinTreeNode<T> predecessor = new BinTreeNode<T>(key.getData());
		return predecessor;
	}

	public BinTreeNode<T> successor(BinTreeNode<T> node) {
		LinkedList<T> traversal = this.inorderTraversal();

		LinkedListNode<T> key = traversal.getFirstNode();
		while (key.getData() != node.getData()) {
			key = key.getNextNode();
		}

		BinTreeNode<T> successor = new BinTreeNode<T>(key.getNextNode().getData());
		return successor;
	}

	private BinTreeNode<T> getParent(BinTreeNode<T> node, T data) {
		BinTreeNode<T> parent = null;

		while (node != null) {
			if (data.compareTo(node.getData()) < 0) {
				parent = node;
				node = node.getLeftChild();
			} else if (data.compareTo(node.getData()) > 0) {
				parent = node;
				node = node.getRightChild();
			} else {
				break;
			}
		}

		return parent;
	}

	public BinTreeNode<T> getParent(BinTreeNode<T> node) {
		return getParent(root, node.getData());
	}

	private void newParentChild(BinTreeNode<T> node, BinTreeNode<T> parent, BinTreeNode<T> child) {
		if (node.getData().compareTo(parent.getData()) < 0) {
			parent.setLeftChild(child);
		} else {
			parent.setRightChild(child);
		}
	}

	public void delete(BinTreeNode<T> node) {
		BinTreeNode<T> parent = getParent(node);
		BinTreeNode<T> successor = successor(node);
		BinTreeNode<T> successorParent = getParent(successor);

		if (node.hasTwoChildren()) {
			node.setData(successor.getData());
			if (successor.isLeaf()) {
				newParentChild(successor, successorParent, null);
			} else {
				newParentChild(successor, successorParent, successor.getRightChild());
			}

		} else if (node.hasLeftChild()) {
			newParentChild(node, parent, node.getLeftChild());
		} else if (node.hasRightChild()) {
			newParentChild(node, parent, node.getRightChild());
		} else {
			newParentChild(node, parent, null);
		}
	}
