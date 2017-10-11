/** 
 * @author Noor Ncho
 * SYSC 2100 Assignment #2 
 * Problem 1
 */
public class TestListReferenceBased {
	private IntNode head;
	private static int numItems; //counter
	
	public TestListReferenceBased() {
		numItems = 0;
	}
	
	/*Sub - class IntNode*/
	public class IntNode{
		public Object item;
		public IntNode next;
		
		public IntNode(Object data) {
			next = null;
			item = data;
		}
		
		public IntNode(Object data, IntNode nextVal) {
			item = data;
			next = nextVal;
		}
		
		public Object getData(){
			return item;
		}
		
		public void setData(Object dataVal){
			item = dataVal;
		}
		public IntNode getNext() {
			return next;
		}
 
		public void setNext(IntNode nextValue) {
			next = nextValue;
		}
	} /*End of IntNode class*/
	
	/**
	 * Checks to see if the list is empty
	 * @return
	 */
	public boolean isEmpty() {
		if(numItems == 0) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Returns the number of elements in the List
	 * @return
	 */
	public int size() {
		return numItems;
	}
	
	/**
	 * Adds an object to the end of the list
	 * @param data
	 */
	public void add(Object data) {
		if(head == null) {
			head = new IntNode(data);
		}
		IntNode temp = new IntNode(data);
		IntNode curr = head;
		if(curr != null) {
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(temp);
		}
		numItems++; //increases the count
	}
	
	/**
	 * Adds an element at a specific point in the List
	 * @param index
	 * @param data
	 */
	public void add(int index, Object data) {
		IntNode curr = head;
		IntNode temp = new IntNode(data);
		if(curr != null) {
			for(int i = 0; i < index && curr.getNext() != null; i++) {
				curr = curr.getNext();
			}
		}
		temp.setNext(curr.getNext());
		curr.setNext(temp);
		numItems++;
	}
	
	/**
	 * Removes an object from a specific point in the list
	 * @param index
	 */
	public void remove(int index) {
		IntNode curr = head;
		if(index >= 0 && index < numItems) {
			if(curr != null) {
				for(int i = 0; i < index; i++) {
					curr = curr.getNext();
				}
			}
			curr.setNext(curr.getNext().getNext());
			numItems--;
		}else {
			System.out.println("Error: Index out of bounds!");
		}
	}
	
	/**
	 * Returns the value of the node at a specific index
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		if(index >= 0 && index < numItems) {
			IntNode curr = find(index);
			Object data = curr.getData();
			return data;
		}else {
			return null;
		}
	}
	
	/**
	 * Removes all objects from the list
	 */
	public void removeAll() {
		head = null;
		numItems = 0;
	}
	
	/**************************************/
	/**
	 * Finds a specific Node in a List
	 * @param index
	 * @return
	 */
	public IntNode find(int index){
		IntNode curr = head;
		for(int i = 0; i < index; i++){
			curr = curr.getNext();
		}
		return curr;
	}
	
	/**
	 * Prints the List
	 */
	public void display() {
		System.out.print(size() + " Items in the Linked List: ");
		for(IntNode curr = head.getNext(); curr != null; curr = curr.getNext()) {
			System.out.print(curr.getData() + " ");
		}
		System.out.println();
	}
	
	/**************************************/
	
	/*Main Function*/
	public static void main(String[] args) {
		TestListReferenceBased test = new TestListReferenceBased();
		
		test.add(12);
		test.add(3);
		test.add(25);
		test.add(18);
		test.display();
		
		test.add(0, 13);
		test.display();
		
		test.add(2, 17);
		test.display();
		
		test.remove(4);
		test.display();
		
		/*test.removeAll();
		test.add(2);
		test.display();*/
	}

}
