/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
public class InsertionSort {
	static int arr[] = {4,1,41,27}; 
	public static void sort(int arr[]) 
    { 
		int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            //shifting elements
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } 
	
	public static void main(String[] args) {
		
		System.out.println("Before Insertion Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		sort(arr);
		System.out.println("Afer Insertion Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
