import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		// Reads in inputs for sorting
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the test numbers: ");
		String[] stringArray = in.nextLine().split(" ");
		in.close();
		
		// Stores the given values into a queue
		LinkedList<Integer[]> splitQueue = new LinkedList<Integer[]>();
		for(int i = 0; i < stringArray.length; ++i) {
			Integer[] temp = {Integer.parseInt(stringArray[i])};
			splitQueue.add(temp);
		}
		
		/* 
		 * This is where the actual sorting takes place.
		 * The reason a linked list is used is because the primary concern while storing sorted arrays is ease 
		 * of inserting new values. It also allows for arrays to be discarded once used, and thus is more memory efficient.
		 */
		while(splitQueue.size()>1) {
			Integer [] arr1 = splitQueue.poll(); // Obtains the arrays to be merged
			Integer [] arr2 = splitQueue.poll();
			Integer[] finalArr = new Integer[arr1.length+arr2.length]; // Creates an array of appropriate length to merge into.
			//This loop sorts the arrays to be merged and puts them into position.
			// counters h and j keep track of the place within the arrays being merged while p does so for the final array.
			for(int p = 0, j = 0, h = 0; p < finalArr.length; ++p) {
				//System.out.println(Arrays.toString(arr2)+" "+Arrays.toString(arr1));
				if(j>=arr1.length) {
					finalArr[p] = arr2[h];
					++h;
				}else if(h>=arr2.length) {
					finalArr[p] = arr1[j];
					++j;
				}else if(arr1[j]<arr2[h]) {
					finalArr[p] = arr1[j];
					j++;
				}else {
					finalArr[p] = arr2[h];
					h++;
				}
				//System.out.println(Arrays.toString(finalArr)+"\n");
			}
			splitQueue.add(finalArr); //Inserts the newly made array into the queue
		}
		
		// Output the sorted array
		System.out.println(Arrays.toString(splitQueue.poll()));
	}

}
// 1 2 3 4 5 6 7 8
// 1 3 5 4 6