/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;

public class Factorial {
	
	public static int getFactorial(int n) 
	{
		return ( n==0 || n==2 || n==1) ?  n :  n * getFactorial(n - 1);
	}

	public static void main(String[] args) {
		int n = 7;
		System.out.println("Factorial of "+n+" is :" + getFactorial(n));

	}

}
