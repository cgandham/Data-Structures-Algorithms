/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SortImagePixels {
	private static String filePathName = "C:\\Users\\ADMIN\\Desktop\\PSA\\Boston.jpg";
	
	
	public static void main(String[] args) throws IOException{
		//try 
		{
			
		    BufferedImage img = ImageIO.read(new File(filePathName));
	     	int[] pixel = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
	     	int[] pixel1 = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
	     	int[] pixel2 = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
	     	int[] pixel3 = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
	     	
	     	
	       //QuickSort
	     	QuickSortPixel.quickSortHelper(pixel);
			QuickSortPixel.printQuickSortedArray(pixel);
			
			//HeapSort
			HeapSortAlgo heapSort = new HeapSortAlgo();
			heapSort.heapsort(pixel1);
			heapSort.print(pixel1);

			//MergeSort
			PixelMergeSort.Sort(pixel2, 0, pixel2.length-1);
			PixelMergeSort.print(pixel2);
			
			//SelectionSort
			int[] arr = PixelSelectionSort.sort(pixel3);
			PixelSelectionSort.print(arr);
			
			
		}
		//catch(IOException ex) 
		{
		//	System.out.println("EXCEPTION"+ex);
		}
	}

}
 class QuickSortPixel {
	public static int[] arr = {};
	public static void quickSortHelper(int[] array) {
		arr = array;
		int low = 0;
		int high = array.length;
		sort(low, high);
		}
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

	public static void printQuickSortedArray(int[] pixels) {
		
		System.out.println("Afer Quick Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
 
 class HeapSortAlgo {

	 public void heapsort(int arr[]) {
	     int temp = 0;
		 for (int i = (arr.length / 2) - 1; i >= 0; i--)
		 heapify(arr, arr.length, i);
		 for (int i = arr.length - 1; i >= 0; i--) {
			 temp = arr[0];
			 arr[0] = arr[i];
			 arr[i] = temp;
			 heapify(arr, i, 0);
	     } 
	 }

	 public void heapify(int arr[], int length, int i) {
		 int large = i;
		 int l = 2 * i + 1;
		 int r = 2 * i + 2;
		 if (l < length && arr[l] > arr[large])
		 large = l;
		 if (r < length && arr[r] > arr[large])
		 large = r;
		 if (large != i) {
			 int temp = arr[i];
			 arr[i] = arr[large];
			 arr[large] = temp;
			 heapify(arr, length, large);
		 }
	 }

	 public void print(int arr[]) {
		 for (int i = 0; i < arr.length; i++) {
		     System.out.print(arr[i] + " ");
		  }
	   }
  }
 
 class PixelMergeSort {
		
		public static int[] merge(int arr[], int l, int m, int r) 
	    { 
	        // Find sizes of two subarrays to be merged 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 
	  
	        int i = 0, j = 0; 
	  
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i] <= R[j]) 
	            { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        while (i < n1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	        while (j < n2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	        
	        return arr;
	    } 
		
		public static int[] Sort(int[] arr,int low,int high) {
			if(low<high) {
				int mid = (high+low) / 2;
				Sort(arr,low,mid);
				Sort(arr,mid+1,high);
			    arr = merge(arr,low,mid,high);
				return arr;
				
			}
			return arr;
		}

		public static void print(int[] pixel2) {
			System.out.println("Afer Merge Sort");
			for (int i = 0; i < pixel2.length; i++) {
				System.out.println(pixel2[i]);
			}
		}

	}
 
 class PixelSelectionSort {
		public static int[] sort(int arr[]) 
	    { 
	        int n = arr.length; 
	  
	        for (int i = 0; i < n-1; i++) 
	        { 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) 
	                if (arr[j] < arr[min_idx]) 
	                    min_idx = j; 
	            // Swap 
	            int temp = arr[min_idx]; 
	            arr[min_idx] = arr[i]; 
	            arr[i] = temp; 
	        } 
	        
	        return arr;
	    } 
		public static void print(int[] arr) {
			System.out.println("Afer Selection Sort");
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		}

	}
 
 
 
