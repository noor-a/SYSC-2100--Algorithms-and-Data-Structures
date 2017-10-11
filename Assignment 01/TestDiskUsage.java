/**
 * @author Noor Ncho
 * SYSC Assignment #1 Part 1
 */

import java.io.File;
import java.util.Scanner;

public class TestDiskUsage {

	public static long diskUsage(File root) {
		long size = root.length();
		if(root.isDirectory()) { //Checks to see if root file is a directory
			for (String childname : root.list()){             
				File child = new File(root, childname);  //Makes the whole pathway        
		        size += diskUsage(child);  
			}
		}
		System.out.println(size + "\t" + root);
		return size;		
	}
	
	/*Main Function*/
	public static void main(String[] args) {
		//Test
		/*String root = "C://Users//nrand//Desktop//SYSC 2100//Assignment 01//SYSC2100Assign01";
		diskUsage(new File (root));*/
		
		String start;
		System.out.print("Enter the start location: ");
		start = new Scanner(System.in).next();
		
	    diskUsage(new File(start));
	}

}
