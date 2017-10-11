/**
 * 
 * @author Noor Ncho
 *
 */

public class StackReferenceBased<T> {

	private  int n;
	private  IntNode top;
	
	public StackReferenceBased() {
		n = 0;
		top = null;
	}
	
	public StackReferenceBased(int lenght) {
		n = lenght;
		top = null;
	}
	
	/*Sub - class IntNode*/
	public class IntNode{
		public T item;
		public IntNode next;
		
		public IntNode(T newItem) {
			next = null;
			item = newItem;
		}
		
		public IntNode(T data, IntNode nextVal) {
			item = data;
			next = nextVal;
		}
	} /*End of IntNode class*/
	
	public void createStack() {
		StackReferenceBased<T> stack= new StackReferenceBased<T>();
	}
	
	public void popAll() {
		while(!this.isEmpty()) {
			IntNode temp = top;
			top = top.next;
			n--;
		}
		top = null;		
	}
	
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void push(T newItem){
		if(top == null) {
			top = new IntNode(newItem);
		}else {
			IntNode temp = new IntNode(newItem);
			temp.next = top;
			top = temp;
			n++;
		}
	}
	
	public T pop() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		IntNode temp = top;
		top = top.next;
		n--;
		return temp.item;
	}
	
	public T peek() throws Exception {
		if(this.isEmpty()) throw new Exception("Stack is Empty");
		IntNode temp = top;
		return temp.item;
	}
	/**Main Function**/
	/*public static void main(String[] args) {
		
	}*/

}
