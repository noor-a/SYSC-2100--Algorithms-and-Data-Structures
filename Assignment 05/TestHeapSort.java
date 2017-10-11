/*
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
*/
/**
 * SYSC2100 - Assignment 05
 * Problem 01
 * 
 * @author Noor Ncho
 *
 */
public class TestHeapSort {
	
	public static void heapSort(int[]array) {
		int n = array.length; //size of the array
		
		
		for(int i = n / 2 -1; i >= 0; i--) {
			heapBuild(array, n, i);
		}
		//int last = n - 1;
		for(int i = n - 1; i >= 0; i--) {
			//Moves the root value to the last position.
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			heapBuild(array, i, 0);
		}
	}
	
	/**
	 * Builds the Heap, but moving an items through the tree until finding
	 * the right place to put it.
	 * @param array
	 * @param i //index
	 * @param n //size of array
	 */
	private static void heapBuild(int[] array, int n, int i) {
		int root = i;
		int left = 2 * i + 1;//index of root left child
		int right = 2 * i + 2;//index of root right child
		
		//if root has a left child, finds the smaller child
		if(left < n && array[left] > array[root]) {
			root = left;			
		}
		//if root has a right child, finds the larger child
		if(right < n && array[right] > array[root]) {
			root = right;
		}
		if(root != i) {
			//Swaps values
			int temp = array[i];
			array[i] = array[root];
			array[root] = temp;
			heapBuild(array, n, root);
		}
	}
	
	/**
	 * A function that prints out the array
	 * @param array
	 */
	public static void print(int[] array) {
		for(int i = 0; i< array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	/*@Test
	public void SortTest(){
		int[] array = {10, 9, 6, 3, 2, 5};
		String correct = "[2, 3, 5, 6, 9, 10]";
		TestHeapSort.heapSort(array);
		assertEquals(correct, Arrays.toString(array));
	}*/
	
	public static void main(String[] args) {
		int[]array = {10, 9, 6, 3, 2, 5};
		System.out.print("Input Array: ");
		print(array);
		
		heapSort(array);
		System.out.print("Sorted Array: ");
		print(array);
		
		System.out.println("Expected Array: 2 3 5 6 9 10");

	}

}
