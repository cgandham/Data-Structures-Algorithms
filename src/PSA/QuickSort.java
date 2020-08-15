/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
public class QuickSort {
	public static int[] arr = {4,1,8,0};
	public static void sort(int l , int h) {
		//checks if there are atleast 2 elements
		if(l<h) {
			  int p = partition(l, h);
			  sort(l,p);
			  sort(p+1,h);
		}
	}
	
	public static int  partition(int l, int h) {
		int pivot = arr[l];
		int pivotIndex = l;
		while(l<h) {
			
			do {l++;}while(l<= arr.length-1 && arr[l]<= pivot);
			do {h--;}while(h > 0 &&  arr[h]> pivot);
			if(l<h) {
				 swap(l,h);
			}
		}
		 swap(pivotIndex,h);
		 //h will be the position where the partition happened
		 return h;
	}
	
	private static void swap(int index1, int index2) {
		int temp = arr[index2];
		arr[index2] = arr[index1];
		arr[index1] = temp;
	}

	public static void main(String[] args) {
		System.out.println("Before Quick Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		sort(0,arr.length);
		
		System.out.println("Afer Quick Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
