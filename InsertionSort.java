import java.util.Arrays;
import java.util.Scanner;

// Insertion Sort. Does exactly what it says on the tin.
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Get data.
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the test numbers: ");
		String[] stringArray = in.nextLine().split(" ");
		in.close();
		int[] numArray = new int[stringArray.length];
		for(int i = 0; i < stringArray.length; ++i) {
			numArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		// Sort.
		for(int k = 0; k < numArray.length-1; ++k){ // this loop verifies if the array is currently in its correct order
			if(numArray[k] > numArray[k+1]) { // checks if a number is in the wrong position
				int temp = numArray[k+1];
				while(true){ // moves the incorrect number down the array until a legal position is found
					if(numArray[k] < temp && temp < numArray[k+1]) {
						numArray[k+1] = temp;
						break;
					}if(k == 0) {
						numArray[k+1] = numArray[k];
						numArray[k] = temp;
						break;
					}else{
						numArray[k+1] = numArray[k];
						--k;
					}
				}
			} // the next iteration of the for loop starts at the index of the last number was inserted, NOT the last value checked
		}
		
		//output results
		System.out.println(Arrays.toString(numArray));
	}
	
}