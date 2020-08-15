/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;

import java.util.ArrayList;

public class n_BitGrayCode {
	
	
	public static void getGrayCode(int n)  
	{  
	    // base case  
	    if (n <= 0)  
	        return;  
	  
	    // 'arr' will store all generated codes  
	    ArrayList<String> arr = new ArrayList<String>();  
	  
	    // start with one-bit pattern  
	    arr.add("0");  
	    arr.add("1"); 
	    generateIterative(arr,n);
		
	    generateRecursive(arr,n);
	  
	   
	}
	
	
	
	public static void generateIterative( ArrayList<String> arr, int code)
	{
		System.out.println("Using Iteration");
		while(arr.get(0).length() != code) {
			int lastIndexOfarr =arr.size()-1;
			//adding elements in reverse order
			for (int i = lastIndexOfarr ; i >= 0 ; i--) {
				String ele = arr.get(i);
				 arr.add(ele);
			}
			//append 0 to the first half
			for (int i = 0; i < arr.size()/2; i++) {
				String ele = "0" + arr.get(i);
				arr.set(i, ele);
			}
			//append 1 to the first half
			for (int i =  arr.size()/2; i < arr.size() ; i++) {
				String ele = "1" + arr.get(i);
				arr.set(i, ele);
			}
		}
		 // print contents of arr[]  
	    for (int i = 0 ; i < arr.size() ; i++ )  
	        System.out.println(arr.get(i));  
	
	}
	
	public static void generateRecursive( ArrayList<String> arr, int n)
	{
		System.out.println("Using Reccursion");
		String[] codes = generateRecursiveGrayCode(4);
		for (int i = 0; i < codes.length; i++) {
		System.out.println(codes[i]);
		}
	}
	
	public static String generateRecursiveCode(int k, int n) {
		if (n == 1) 
		    return new Integer(k).toString();
		else if (k < (int) Math.pow(2, n - 1)) 
		return "0" + generateRecursiveCode(k, n - 1);
	    else 
		return "1" + generateRecursiveCode((int) Math.pow(2, n) - 1 - k, n - 1);
     }

	public static String[] generateRecursiveGrayCode(int n) {
		String[] result = new String[(int) Math.pow(2, n)];
		for (int k = 0; k < (int) Math.pow(2, n); k++) {
		result[k] = generateRecursiveCode(k, n);
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		getGrayCode(4);  
	}
	
}
