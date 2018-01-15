import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	// TODO Write comments!!!
	public static void main(String[] args) throws IOException {
		//File test = new File("Test");
		//Scanner in = new Scanner(test, "UTF-8");
		/*System.out.print("Please enter numbers: ");
		String[] sArray = in.nextLine().split(" ");
		in.close();
		int[] numArray = new int[sArray.length];
		for(int i = 0; i < sArray.length; ++i) {
			numArray[i] = Integer.parseInt(sArray[i]);
		}*/
		Random rand = new Random();
		int[] numArray = new int[1000];
		for(int i = 0; i<100; i++) {
			numArray[i] = rand.nextInt(10000);
		}
		//in.close();
		QuickSort sorter = new QuickSort();
		
		System.out.println(Arrays.toString(sorter.sort(numArray)));
	}
	
	private int[] arr;
	
	public QuickSort() {}
	
	public int[] sort(int[] arr) {
		//System.out.println( "sort");
		this.arr = arr;
		qSort(0,this.arr.length-1);
		return this.arr;
	}
	private void qSort(int lo, int hi) {
		//System.out.println("qSort"+" "+lo+" "+hi+"\n"+Arrays.toString(this.arr));
		if(hi-lo>0) {
			int pivotPoint = partition(lo,hi);
			qSort(lo, pivotPoint-1);
			qSort(pivotPoint+1,hi);
		}
	}
	private int partition(int lo, int hi) {
		//System.out.println("partition"+" "+lo+" "+hi);
		int pivot = this.arr[hi];
		int pivotIndex = hi;
		hi--;
		if(lo==hi) {
			if(this.arr[lo]>pivot) {
				swap(lo, pivotIndex);
				return lo;
			}else {
				return lo;
			}
		}
		while(true) {
			while(this.arr[lo]<pivot&&lo<this.arr.length) {
				//System.out.println(lo);
				lo++;
			}
			while(this.arr[hi]>pivot&&hi>0) {
				hi--;
			}
			if(hi>lo) {
				swap(lo,hi);
			}else {
				break;
			}
		}
		swap(lo,pivotIndex);
		return lo;
	}
	private void swap(int index1, int index2) {
		//System.out.println("swap");
		int temp = this.arr[index1];
		this.arr[index1] = this.arr[index2];
		this.arr[index2] = temp;
	}
}
//2 5 3 79 58 82
//5 64 85 32 15 44 95 34 11 57 8 3 9
//5 64 85 32 15 44 95 34 11 57 8 3 9 36 66 154 265 255 879 6665 468 31526 48 955 62 884 25 186 282 2864 172 2936 82 44 658 994 998 965 15 488 6482 35 948 16 658 444 777 826 384