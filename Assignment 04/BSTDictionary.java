
public class BSTDictionary<E, K extends Sortable> implements Dictionary<E, K>{	
	BSTNode<E, K> root;

	/**
	 * Constructors for the binary search tree
	 */
	public BSTDictionary() {
		this(null);
	}

	public BSTDictionary(BSTNode<E, K> root) {
		this.root = root;
	}
	
	/**
	 * Iterates through the binary tree  calling the searchNode() method to get
	 * to a specific key and returns the element at that position
	 * 
	 * @param key
	 * @return
	 */
	public E search(K key) {
		BSTNode<E, K> nodeFound = searchNode(key);
		if(nodeFound == null) {
			return null; //not found
		}
		else return nodeFound.getElement();
	}
	
	/**
	 * A Method that calls searchBelow() to find the element with the specified key
	 * 
	 * @param key
	 * @return
	 */
	public BSTNode<E, K> searchNode(K key){
		if(key == null) {
			return null; //looking for nothing
		}
		if(root == null) {
			return null; //tree is empty
		}
		//if the keys are equal
		if(key.compareTo(root.getKey()) == 0) {
			return root;
		}
		//if key is less than the root key
		else if(key.compareTo(root.getKey()) < 0) {
			return searchBelow(root.getLeft(), key);
		}
		//if key is greater than the root key
		else if(key.compareTo(root.getKey()) > 0) {
			return searchBelow(root.getRight(), key);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Recursive method to fine the location of a specific key
	 * 
	 * @param n
	 * @param key
	 * @return
	 */
	public BSTNode<E,K> searchBelow(BSTNode<E, K> n, K key) {
		if(n == null) {
			return null; 
		}
		//found key looking for
		if(key.compareTo(n.getKey()) == 0) {
			return n;
		}
		//given key greater than key of current node
		else if (key.compareTo(n.getKey()) > 0) {
			return searchBelow(n.getRight(), key);
		}
		//given key less than key of current node
		else if(key.compareTo(n.getKey()) < 0) {
			return searchBelow(n.getLeft(), key);
		}
		else return null;
	}

	/**
	 * A method that calls the insertBelow() method, and inserts a specifed element at
	 * a specified key.
	 * 
	 * @param key
	 * @param element
	 */
	public void insert(K key, E element) {
		if(root == null) {
			root = new BSTNode<E, K>(key, element, null, null);
		}
		else {
			insertBelow(root, key, element);
		}		
	}

	/**
	 * Recursive method that iterates thought the tree until getting to the right key and
	 * creates a node with that element.
	 * 
	 * @param root
	 * @param key
	 * @param element
	 */
	public void insertBelow(BSTNode<E, K> root, K key, E element) {
		
		//if the key equals the root.
		if(key.compareTo(root.getKey()) == 0) {
			
		}
		//The key is greater than the current node's key so it goes to the right 
		else if(key.compareTo(root.getKey()) > 0) {
			if(root.getRight() == null) {
				//Creates and sets the right child node
				root.setRight(new BSTNode<E, K>(key, element, null, null));
			}else {
				insertBelow(root.getRight(), key, element);
			}
		}
		//The key is less than the current node's key so it goes to the left
		else if(key.compareTo(root.getKey()) < 0) {
			if(root.getLeft() == null) {
				//Creates and sets the left child node
				root.setLeft(new BSTNode<E, K>(key, element, null, null));
			}else {
				insertBelow(root.getLeft(), key, element);
			}
		}		
	}

	/**
	 * Deletes the element at the specified key, but calling the recursive deleteR() method
	 * 
	 * @param key
	 */
	public void delete(K key) {
		this.root = deleteR(root, key);		
	}
	
	/**
	 * A Recursive method that calls the deleteDoubleNode() method and iterates through the tree,
	 * starting at the specified node, until it gets to the specified key and deletes the element 
	 * at that key location.
	 * 
	 * @param n
	 * @param key
	 * @return
	 */
	public BSTNode<E, K> deleteR(BSTNode<E, K> n, K key){
		//Checks to see if at the specified key location
		if(key.compareTo(n.getKey()) == 0) {
			//If the node is a leaf
			if(n.getLeft() == null && n.getRight() == null) {
				return null;
			}
			//Node with only one child; the right child
			else if((n.getLeft() == null) && (n.getRight() != null)) {
				return n.getRight();
			}
			//Node with only on child; the left child
			else if((n.getLeft() != null) && (n.getRight() == null)) {
				return n.getLeft();
			}
			//If it is a node with 2 children
			else if((n.getLeft() != null) && (n.getRight() != null)) {
				BSTNode<E, K> newNode = findMin(n.getRight()); 
				BSTNode<E, K> newLeft = n.getLeft();
				newNode.setRight(deleteDoubleNode(n.getRight())); 
				newNode.setLeft(newLeft);
				return newNode;
			}else {
				return n;
			}
		}
		//Checks if to go to the left child
		else if(key.compareTo(n.getKey()) < 0) {
			if(n.getLeft() != null) {
				n.left = deleteR(n.getLeft(), key);
				return n;
			}
		}
		//Checks if to go the right child
		else {
			if(n.getRight() != null) {
				n.right = deleteR(n.getRight(), key);
				return n;
			}
		}
		return n;		
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public BSTNode<E, K> deleteDoubleNode(BSTNode<E, K> n) {
		if(n.getLeft() == null) {
			//at the bottom of the nodes.
			return n.getRight();
		}
		else {
			n.setLeft(deleteDoubleNode(n.getLeft()));
		}
		return n;

	}
	
	/**
	 * Call the inorder() method to print the binary tree in ascending order.
	 */
	public void printTree() {
		System.out.println("\nBSTree...");
		inorder(root);
	}
	
	/**
	 * A recursive method, that goes through the binary tree and prints the key,
	 * and respective element in order.
	 * 
	 * @param node
	 */
	public void inorder(BSTNode<E,K> node) {
		if(node != null) {
			inorder(node.getLeft()); //get the left keys 
			System.out.println("key: " + node.getKey().toString() + " element: " + node.getElement().toString());
			inorder(node.getRight()); //get the right keys.
		}
	}
	
	/**
	 * A method that calls the postOrderDepth() method to return the integer value of the number
	 * of elements that are inside the tree/
	 * 
	 * @return
	 */
	public int depth() {
		return postorderDepth(root, 0);
	}
	
	/**
	 * A Recursive counting method that goes through the tree counting the number of node that it
	 * visits until getting the bottom of of the tree from the initial specified node.
	 * 
	 * @param node
	 * @param count
	 * @return
	 */
	private int postorderDepth(BSTNode<E, K> node, int count) {
		if(node != null) {
			return Math.max(postorderDepth(node.getLeft(), count + 1), postorderDepth(node.getRight(), count + 1));
		}
		else return count;
	}
	
	/**
	 * Iterates through the binary tree until it gets the left most node,
	 * which would be the smallest node in the tree.
	 * 
	 * @param n
	 * @return
	 */
	public BSTNode<E, K> findMin(BSTNode<E, K> n) {
		while(n.getLeft() != null) {
			n = n.getLeft();
		}
		return n;
	}

}
