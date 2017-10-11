import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class testMergeSort {

	public static <T extends Comparable <? super T>> void mergeSort(T[] array) {
		@SuppressWarnings("unchecked")
		T[] tempArr = (T[]) new Comparable<?>[array.length];
		mergeSort(array, tempArr, 0, array.length - 1);
	}
	
	
	private static <T extends Comparable <? super T>> void mergeSort(T[] array, T[] tempArr, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, tempArr, start, mid);
			mergeSort(array, tempArr, mid + 1, end);
			merge(array, tempArr, start, mid, end);
		}
		
	}


	private static <T extends Comparable <? super T>> void merge(T[] array, T[] tempArr, int start, int mid, int end) {
		int f1 = start, l1 = mid;
		int f2 = mid + 1, l2 = end;
		
		int index = f1;
		
		while(f1 <= l1 && f2 <= l2) {
			if(array[f1].compareTo(array[f2]) < 0) {
				tempArr[index] = array[f1++];
			}else {
				tempArr[index] = array[f2++];
			}
			index++;
		}
		
		while(f1 <= l1) {
			tempArr[index] = array[f1++];
			index++;
		}
		
		while(f2 <= l2) {
			tempArr[index] = array[f2++];
			index++;
		}
		
		for(index = start; index <= end; index++) {
			array[index] = tempArr[index];
		}
	}

	/**
	 * JUnit test method.
	 */
	@Test
	public void Stringtest(){
		String[] array = {"Lisa", "Adam", "John", "Vicky", "George", "Beth", "Kate", "Aaron", "Jinny"};
		String correct = "[Aaron, Adam, Beth, George, Jinny, John, Kate, Lisa, Vicky]";
		testMergeSort.mergeSort(array);
		assertEquals(correct, Arrays.toString(array));
	}
	
	
	/*public static void main(String[] args) {
		String[] array = {"Lisa", "Adam", "John", "Vicky", "George", "Beth", "Kate", "Aaron", "Jinny"};
		String[] correct = {"Aaron", "Adam", "Beth", "George", "Jinny", "John", "Kate", "Lisa", "Vicky"};
		boolean same = true;
		
		System.out.print("Expected array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(correct[i] + " ");
        }
        System.out.println();
		
		mergeSort(array);		
		System.out.print("Actual array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        
        //Checks to see if the merge array matches the expected array
        while(same) {
        	for(int i = 0; i < array.length; i++) {
        		if(array[i].equals(correct[i])) {
        			same = true;
        		}else {
        			same = false;
        			System.out.println("Error");
        			return;
        		}
        	}
        	System.out.println("Correct");
        	return;
        }
        
	}*/

}
