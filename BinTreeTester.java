import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinTreeTester {

	@Test
	void test() {
		int[] numbers = {5, 9, 7, 1, 6, 2};
		DefaultBinSearchTree<Integer> tree = new DefaultBinSearchTree<Integer>();
		
		for (int num : numbers) {
			tree.insert(num);
		}
		
		/*Checks to see if all elements were inserted into the tree, and that it was done so correctly
		 * via an in-order traversal*/
		assertEquals("1 -> 2 -> 5 -> 6 -> 7 -> 9", tree.inorderString(), "insert() and Inorder Test");
		
		BinTreeNode<Integer> one = tree.search(1);
		BinTreeNode<Integer> five = tree.search(5);
		BinTreeNode<Integer> six = tree.search(6);
		
		//Checks to see if the "6" element was properly found by the search() method
		assertEquals("6", six.toString(), "search() Test");
		
		//Checks to see if the minElement() method actually finds the minimum element in the tree
		assertEquals(1, tree.minElement(), "minElement() Test");
		
		//Checks to see if the maxElement() method actually finds the maximum element in the tree
		assertEquals(9, tree.maxElement(), "maxElement() Test");
		
		//Checks to see if the predecessor() method returns the predecessor of the given node
		assertEquals("5", tree.predecessor(six).toString(), "predecessor() Test");
		
		//Checks to see if the successor() method returns the successor of the given node
		assertEquals("7", tree.successor(six).toString(), "successor() Test");
		
		assertEquals(4, tree.countNonLeaves(), "countNonLeaves() Test");
		
		tree.delete(six);
		
		//Checks if delete() method works for leaf node
		assertEquals("1 -> 2 -> 5 -> 7 -> 9", tree.inorderString(), "Delete Leaf Node Test");
		
		tree.delete(one);
		
		//Checks if delete() method works for a node with one child
		assertEquals("2 -> 5 -> 7 -> 9", tree.inorderString(), "Delete One-Child Node Test");
		
		tree.delete(five);
		
		//Checks if delete() method works for a node with two children
		assertEquals("2 -> 7 -> 9", tree.inorderString(), "Delete Two-Children Node Test");
	}

}
