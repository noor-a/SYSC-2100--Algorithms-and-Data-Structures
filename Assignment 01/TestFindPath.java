/**
 * @author Noor Ncho
 * SYSC 2100 Assignment #1 Part 2
 */
import java.io.File;
import java.util.Scanner;

public class TestFindPath {

	public static File find(File root, String fileName) {
		if(root.isDirectory()) { //Checks to see if the root file is a directory
			File[] list = root.listFiles();
			for (File f: list){ //Iterates through the other files and directories inside the root.
				File found = find(f, fileName); //Calls the method again and names the return type.
				if(found != null){ // Checks it is there.
					return found;
				}
			}
		}else{
			if(root.getName().contains(fileName)){ // Checks that the path name contains the file name
				return root;					
			}
		}
				
		
		/*File[] list = root.listFiles();
		if(list != null){
			for (File file: list){ //Iterates through through the root directory
				//File found = null;
			    if(file.isDirectory()){// CHecks to see if the current file name is a directory or not
					File found = find(file, fileName); 
					if(found != null){
						return found;
					}
				}else{
					if(file.getName().contains(fileName)){ //
						//found = file.getAbsoluteFile(); //Returns the full path name of the file
						return file;					
					} 
				}
			}
		}*/
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the Path of the root file: ");
		String root = new Scanner(System.in).next();
		System.out.println("Enter file name to be found: ");
		String fileName = new Scanner(System.in).next();
		File found = find(new File(root), fileName);
		System.out.println();
		System.out.println("The path of the "+ fileName+" is "+ found);//.getAbsolutePath());
	}

}
