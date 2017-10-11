/**
 * SYSC 2100 - Assignment 05
 * Problem 02
 * 2-3 Tree Implementation
 * 
 * Note:- 
 * 	Unable to complete the deletion method, or get the display to work 
 * 
 * @author Noor Ncho
 *
 */
public class TestTwoThreeTree {

	public static Node root;
	private final int EMPTY = Integer.MAX_VALUE;
	
	public TestTwoThreeTree(){
		//root.setParent(null);
		root = null;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void insert(int value) {
		Node curr = root;
		Node sNode = findLeaf(curr, value);	
		
		//First insertion
		if(root == null) {
			root = new Node(value, EMPTY, EMPTY);
			return;
		} 
		//Node has only one data item
		else if(sNode.getLargeItem() == EMPTY) {
			if(value < sNode.getSmallItem()) {
				sNode.setLargeItem(sNode.smallItem);
				sNode.setSmallItem(value);
			}else {
				sNode.largeItem = value;
			}
			return;
		}
		//Node already has two data items
		else if(curr.getLargeItem() != EMPTY && sNode.getSmallItem() != EMPTY) {
			if(value < sNode.smallItem && value < sNode.largeItem) {
				//Replaces the curr leaf node with a new  leaf node newNode
				sNode.midItem = sNode.smallItem;
				sNode.smallItem = value;
				//sNode = new Node(value, sNode.smallItem, sNode.largeItem);
				/*Node newNode = new Node(value, curr.smallItem, curr.largeItem);
				newNode.setParent(curr.getParent());
				curr.setParent(null);*/
			}
			else if(value > sNode.largeItem && value > sNode.smallItem) {
				//Replaces the curr leaf node with a new  leaf node newNode
				//sNode = new Node(sNode.smallItem, sNode.largeItem, value);
				sNode.midItem = sNode.largeItem;
				sNode.largeItem = value;
				/*Node newNode = new Node(curr.smallItem, curr.largeItem, value);
				newNode.setParent(curr.getParent());
				curr.setParent(null);*/
			}else if(value > sNode.smallItem && value < sNode.largeItem) {
				//Replaces the curr leaf node with a new  leaf node newNode
				sNode.midItem  = value;
				//sNode = new Node(sNode.smallItem, value, sNode.largeItem);
				/*Node newNode = new Node(curr.smallItem, value, curr.largeItem);
				newNode.setParent(curr.getParent());
				curr.setParent(null);*/
			}
			split(sNode);//The Node will have three data items so will be split
		}
		
	}
	
	
	public void delete() {
		
	}
	
	
	public void inorder(Node n) {
		if(isLeaf(n)) {
			System.out.print(n.getSmallItem() +" ");
			if(n.getLargeItem() != EMPTY) {
				System.out.print(n.getLargeItem());
			}
			System.out.println();
		}
		//node has two data items
		else if(n.getSmallItem() != EMPTY && n.getLargeItem() != EMPTY){
			inorder(n.getLeftChild());
			System.out.print(n.getSmallItem() + " ");
			inorder(n.getMidChild());
			System.out.print(n.getLargeItem() + " ");
			inorder(n.getRightChild());
		}
		//node has one data item
		else {
			inorder(n.getLeftChild());
			System.out.print(n.getSmallItem() + " ");
			inorder(n.getRightChild());
		}		
	}
	
	public void display() {
		System.out.println("2-3 Tree:-----");
		inorder(root);
	}
	
	/***************************/
	
	/**
	 * Checks to see if the current Node is a leaf
	 * @param n
	 * @return
	 */
	public boolean isLeaf(Node n){
		if(n.getLeftChild() == null && n.getMidChild() == null
				&& n.getRightChild()==null/*n.getFirstChild() == null && n.getSecondChild() == null &&
				n.getThirdChild() == null && n.getFourthChild() == null*/){
			return true;
		}
		return false;
	}
	
	/*public void find(Node n, int key) {
		int foundItem;
		Node found;
		
		if(n.getSmallItem() == key || n.getLargeItem() == key) {
			foundItem = key;
		}
		else if(isLeaf(n)) {
			found = null;
		}
		//Searches the appropriate subtree
		 * 
		//node has two data items
		else if(n.getSmallItem() != EMPTY && n.getLargeItem() != EMPTY) {
			if(key < n.getSmallItem()) {
				find(n.getLeftChild(), key);
			}else if(key < n.getLargeItem()) {
				find(n.getMidChild(), key);
			}else {
				find(n.getRightChild(), key);
			}
		}
		//node has one data item
		else {
			if(key < n.getSmallItem()) {
				find(n.getLeftChild(), key);
			}else {
				find(n.getRightChild(), key);
			}
		}
	}*/
	
	public Node findLeaf(Node root, int key) {
		if(root == null) return root;
		
		Node curr = root;
		if(isLeaf(curr)) {
			return curr;
		}
		//node has two data items
		else if(curr.getSmallItem() != EMPTY && curr.getLargeItem() != EMPTY) {
			if(key < curr.getSmallItem()) {
				curr = findLeaf(curr.getLeftChild(), key);
			}else if(key < curr.getLargeItem()) {
				curr = findLeaf(curr.getMidChild(), key);
			}else {
				curr = findLeaf(curr.getRightChild(), key);
			}
		}
		//node has one data item
		else {
			if(key < curr.getSmallItem()) {
				curr = findLeaf(curr.getLeftChild(), key);
			}else {
				curr = findLeaf(curr.getRightChild(), key);
			}
		}
		
		return curr;
	}
	
	
	public void split(Node n) {
		Node p = n.getParent(); 
		//Node n is a root
		if(n.getParent() == null) {
			p = new Node(EMPTY, EMPTY, EMPTY);
		}else {
			p = n.getParent();
		}
		
		Node n1 = new Node(n.smallItem, EMPTY, EMPTY);
		Node n2 = new Node(n.largeItem, EMPTY, EMPTY);
		//Replaces n with n1 & n2 whose parent is p;
		n1.setParent(n.getParent());
		n2.setParent(n.getParent());
		n.setParent(null);
		int temp = n.midItem;
		
		
		if(!isLeaf(n)) {
			n1.setLeftChild(n.getFirstChild());
			n1.setRightChild(n.getSecondChild());
			n2.setLeftChild(n.getThirdChild());
			n2.setRightChild(n.getFourthChild());
		}
		
		//Moves the middle value from node n up to the parent and places
		//it in the right position
		if(temp < p.smallItem && temp < p.largeItem) {
			p.midItem = p.smallItem;
			p.smallItem = temp;
		}else if(temp > p.smallItem && temp < p.largeItem) {
			p.midItem = temp;
		}else {
			p.midItem = p.largeItem;
			p.largeItem = temp;
		}
		
		if(p.smallItem != EMPTY && p.midItem != EMPTY && p.largeItem != EMPTY) {
			split(p);
		}
		return;
	}
	
	public static void main(String[] args) {
		TestTwoThreeTree tree = new TestTwoThreeTree();
		
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
		tree.insert(9);
		tree.insert(10);
		tree.display();
		
		//tree.delete(3);
		//tree.delete(7);
		//tree.display();
		
		//tree.delete(13);

	}

}
