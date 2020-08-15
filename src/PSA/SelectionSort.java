/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
public class SelectionSort {
	static int arr[] = {4,1,8,0,41,27}; 
	public static void sort(int arr[]) 
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
    } 
	public static void main(String[] args) {
		
		System.out.println("Before Selection Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		sort(arr);
		System.out.println("Afer Selection Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
