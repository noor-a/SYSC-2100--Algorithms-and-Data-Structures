/**
 * SYSC 2100 Assignment #3
 * @author Noor Ncho
 *
 */
import java.util.*;

public class TestInfix2PostfixConverter {
	
	public static String Infix2PostfixConverter(String exp) throws Exception {
		StackReferenceBased<String> stack = new StackReferenceBased<String>();
		
		String openParen;
		StringBuilder postfix = new StringBuilder(); //String of postfix
		StringTokenizer tokens = new StringTokenizer(exp);
		
		while(tokens.hasMoreTokens()) {
			
			String tkn = tokens.nextToken();
			if(!isSymbol(tkn)) {
				postfix.append(" ").append(tkn);
			}
			else if(tkn.equals("(")) { //Saves "(" to the stack	
				stack.push(tkn);
			}
			else if(tkn.equals(")")){ //pop the stack until matching "("
				
				//Appends the postfix, until reaching the matching "("
				while (!stack.peek().equals("(") && !stack.isEmpty()) {
					postfix.append(" ").append(stack.pop());
				}
				openParen = stack.pop(); //discards "("
			}
			else if(isOperator(tkn)) {//Adds operator to the stack if it is empty
				if(stack.isEmpty()) {
					stack.push(tkn);
				}else {
					//Checks the precedence of the operators and appends them to the postfix 
					//if needed
					while(!stack.isEmpty() && !stack.peek().equals("(") &&
							precedence(tkn) <= precedence(stack.peek())) {
						postfix.append(" ").append(stack.pop());					
					}
					stack.push(tkn);
				}
			}			
		}
		
		//appends remaining operators on the stack to postfix
		while(!stack.isEmpty()) {
			postfix.append(" ").append(stack.pop());
		}		
		return postfix.toString();
	}
	
	/**
	 * Solves the Postfix expression and returns the integer value
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static int solvePostfix(String str) throws Exception {
		String exp = Infix2PostfixConverter(str);
		StackReferenceBased<Integer> stack = new StackReferenceBased<Integer>();
		Scanner scan = new Scanner(exp);
		
		while(scan.hasNext()) {
			if(scan.hasNextInt()) {
				stack.push(scan.nextInt());
				continue;
			}
			int num2 = stack.pop();
			int num1 = stack.pop();
			char op = scan.next().charAt(0);
			
			switch(op) {
			case '+':
				stack.push(num1 + num2);
				break;
			case '-':
				stack.push(num1 - num2);
				break;
			case '*':
				stack.push(num1 * num2);
				break;
			case '/':
				stack.push(num1 / num2);
				break;
			}
		}
		scan.close();
		return stack.pop();
	}
	
	/**
	 * Checks to see if the character is an operation
	 * @param str
	 * @return
	 */
	public static boolean isOperator(String str) {
		if(str.equals("+")|| str.equals("-")||str.equals("*")||str.equals("/")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isSymbol(String str) {
		if(str.equals("+")|| str.equals("-")||str.equals("*")||str.equals("/")
				|| str.equals("(") ||str.equals(")")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int precedence(String str) {
		if(str.equals("+") || str.equals("-")) {
			return 1;
		}
		return 2;
	}
	
	/**********Main function
	 * @throws Exception **********/
	public static void main(String[] args) throws Exception {
		String str;
		
		//Test 1
		//str = "10 + 3 * 4 / 6"; 
		str = "( 10 + 3 * 4 / 6 )";
		System.out.println("Infix: " + str);
		System.out.println("Postfix: " + Infix2PostfixConverter(str));
		System.out.println("Result: " + solvePostfix(str));
		System.out.println();
		
		//Test 2
		//str = "12 * 3 - 4 + 18 / 6";
		str = "12 * 3 - 4 + ( 18 / 6 )";
		System.out.println("Infix: " + str);
		System.out.println("Postfix: " + Infix2PostfixConverter(str));
		System.out.println("Result: " + solvePostfix(str));
		System.out.println();
		
		//Test 3
		str = "35 - 42 * 17 / 2 + 10";
		System.out.println("Infix: " + str);
		System.out.println("Postfix: " + Infix2PostfixConverter(str));
		System.out.println("Result: " + solvePostfix(str));
		System.out.println();
		
		//Test 4
		//str = "3 * 4 + 5";
		str = "3 * ( 4 + 5 )";
		System.out.println("Infix: " + str);
		System.out.println("Postfix: " + Infix2PostfixConverter(str));
		System.out.println("Result: " + solvePostfix(str));
		System.out.println();
		
		//Test 5
		//str = "3 * 17 - 5 + 2 / 2 + 3";
		str = "3 * ( 17 - ( 5 + 2 ) ) / ( 2 + 3 )";
		System.out.println("Infix: " + str);
		System.out.println("Postfix: " + Infix2PostfixConverter(str));
		System.out.println("Result: " + solvePostfix(str));
		System.out.println();
	}

}
