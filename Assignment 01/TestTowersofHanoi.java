/**
 * @author Noor Ncho 
 * SYSC 2100 Assignment #1 Part 3
 */
import java.util.Scanner;

public class TestTowersofHanoi {

	public static int solveTower(int n, char src, char dest, char spare, int instructionNum) {
		
		if(n == 1) {
			System.out.println(instructionNum++ + ". Move disk " + n +" from "+ src+ " to "+ dest); //Moves the disk directly from source to destination (ie A to C)
		}else {
			
			instructionNum = solveTower(n-1, src, spare, dest, instructionNum++); //Moves a disk from the source to the spare (ie A to B)
			System.out.println(instructionNum++ +". Move disk "+ n + " from "+ src+ " to "+ dest);
			//solveTower(1, src, dest, spare)  //Moves the disk directly from source to destination (ie A to C
			instructionNum = solveTower(n-1, spare, dest, src, instructionNum); //Moves a disk from the spare to the destination (ie B to C)
		}
		//System.out.println("Number of Steps: " + instructionNum);
		return instructionNum;
	}
	
	/*Main Function*/
	public static void main(String[] args) {
		/*Tests*/
		//solveTower(3, 'L', 'R', 'M', 1);
		//solveTower(4, 'L', 'R', 'M', 1);
		
		System.out.println("Enter number of disk, source, destination, spare(Enter after each): ");
		int n = new Scanner(System.in).nextInt();
		char src = new Scanner(System.in).nextLine().charAt(0);
		char dest = new Scanner(System.in).nextLine().charAt(0);
		char spare = new Scanner(System.in).nextLine().charAt(0);
		
		solveTower(n, src, dest, spare, 1);
		
	}

}
