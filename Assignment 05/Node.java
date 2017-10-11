
public class Node {

		int smallItem;
		int largeItem;
		int midItem;
		int nodeType;
		int numItems;
		
		private Node firstChild;
		private Node secondChild;
		private Node thirdChild;
		private Node fourthChild;
		private Node parent;
		
		private Node leftChild;
		private Node rightChild;
		private Node midChild;
		//private final int EMPTY = Integer.MAX_VALUE;
		
		//Constructors
		public Node(int small, int large){
			smallItem = small;
			largeItem  = large;
			numItems = 1;
			init();
			nodeType = 2;			
		}
		
		public Node(int small, int mid, int large) {
			smallItem = small;
			largeItem  = large;
			midItem = mid;
			//numItems = 1;
			nodeType = 2;
		}
		
		public void init(){
			setFirstChild(null);
			setSecondChild(null);
			setThirdChild(null);
			setFourthChild(null);
			
			setLeftChild(null);
			setRightChild(null);
			//parent = null;
		}
		
		public int getSmallItem() {
			return smallItem;
		}
		
		public void setSmallItem(int smallItem) {
			this.smallItem = smallItem;
			//numItems++;
		}
		
		public int getLargeItem() {
			return largeItem;
		}
		
		public void setLargeItem(int largeItem) {
			this.largeItem = largeItem;
			//numItems++;
		}
		
		public int getMidItem() {
			return midItem;
		}
		
		public void setMidItem(int midItem) {
			this.midItem = midItem;
			//numItems++;
		}
		
		
		public Node getParent() {
			return parent;
		}
		
		public void setParent(Node parent) {
			this.parent = parent;
		}
		
		public Node getFirstChild() {
			return firstChild;
		}

		public void setFirstChild(Node firstChild) {
			this.firstChild = firstChild;
		}

		public Node getSecondChild() {
			return secondChild;
		}

		public void setSecondChild(Node secondChild) {
			this.secondChild = secondChild;
		}

		public Node getThirdChild() {
			return thirdChild;
		}

		public void setThirdChild(Node thirdChild) {
			this.thirdChild = thirdChild;
		}

		public Node getFourthChild() {
			return fourthChild;
		}

		public void setFourthChild(Node fourthChild) {
			this.fourthChild = fourthChild;
		}

		public int getNodeType() {
			return nodeType;
		}
		
		public void setNodeType(int nodeType) {
			this.nodeType = nodeType;
		}

		public int getNumItems() {
			return numItems;
		}

		public void setNumItems(int numItems) {
			this.numItems = numItems;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}

		public Node getMidChild() {
			return midChild;
		}

		public void setMidChild(Node midChild) {
			this.midChild = midChild;
		}
}
