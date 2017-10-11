/**
 * SYSC Assignment #2
 * Problem 2
 * @author Noor Ncho
 *
 */
import java.io.*;
import java.util.*;

public class CountSubstrings {

	public static void findAndCount(FileReader file, String pattern) throws IOException{
		BufferedReader buffer = new BufferedReader(file);
		String line = buffer.readLine();

		ArrayList<String>strArr = new ArrayList<String>();
		LinkedList<String>strList = new LinkedList<String>();


		//Reads and adds all the words to the ArrayList and the LinkedList
		while(line != null){

			String temp = "";
			for(int i = 0; i < line.length(); i++){

				if(line.charAt(i) == ' '){

					temp += '@';
					strArr.add(temp);
					strList.add(temp);
					temp = "";

				}else if(i == line.length() - 1){

					temp += line.charAt(i);
					temp += '@';
					strArr.add(temp);
					strList.add(temp);
					temp = "";

				}else{
					temp += line.charAt(i);
				}
			}

			line = buffer.readLine();

		}
		buffer.close();

		ArrayList<Character>patternArr = new ArrayList<Character>();

		for(int i = 0; i < pattern.length(); i++){
			patternArr.add(pattern.charAt(i));
		}

		/**
		 * Finds the number of occurrences of the specified pattern and times how long it takes
		 * using ArrayList
		 * findBrute method is used to see if the patter is in the given ArrayList
		 */
		int count = 0;
		long time = System.currentTimeMillis();

		for(String str:strArr){
			ArrayList<Character> charArr = new ArrayList<Character>();
			for(int i = 0; i < str.length(); i++){
				charArr.add(str.charAt(i));
			}
			if(findBrute(charArr, patternArr) != -1){
				count++;
			}
		}
		System.out.println("Using ArrayLists: " + count + " matches, derived in "
				+ (System.currentTimeMillis() - time) + " milliseconds.");

		/**
		 * Finds the number of occurrences of the specified pattern and times how long it takes
		 * using LinkedList.
		 * findBrute method is used to see if the patter is in the given LinkedList
		 */
		count = 0;
		time = System.currentTimeMillis();
		for(String strl:strList){
			LinkedList<Character>charList = new LinkedList<Character>();
			for(int i = 0; i < strl.length(); i++){
				charList.add(strl.charAt(i));
			}
			if(findBrute(charList, patternArr) != -1){
				count++;
			}
		}
		System.out.println("Using LinkedLists: " + count + " matches, derived in "
				+ (System.currentTimeMillis() - time) + " milliseconds.");
	}
	
	/**********************************/
	
	/**
	* Returns the lowest index at which substring pattern begins in text (or
	* else -1).
	*/
	private static int findBrute(List<Character> text, List<Character> pattern) {
		int n = text.size();
		int m = pattern.size();
		for (int i = 0; i <= n - m; i++) { // try every starting index
			// within text
			int k = 0; // k is index into pattern
			while (k < m && text.get(i + k) == pattern.get(k)){
				// kth character of pattern matches
				k++;
			}
			if (k == m){ // if we reach the end of the pattern,
				return i;// substring text[i..i+m-1] is a match
			}
		}
		return -1; // search failed
	}
	
	/*Main Function*/
	public static void main(String[] args) {
		FileReader file = null;

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the path for the input file: ");
		String inFile = scan.nextLine();
		System.out.println("Enter the pattern to look for: ");
		String pattern = scan.nextLine();
		scan.close();

		try {
			file = new FileReader(inFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			findAndCount(file, pattern);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
