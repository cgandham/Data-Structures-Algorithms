/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
public class Fibonacci {
	
	public static  int getFibonacciRecursion(int n) 
	{
		return n==1 || n==2 ?  1 : getFibonacciRecursion(n-1) + getFibonacciRecursion(n-2);
	}

	public static  void getFibonacciIterative(int n) 
	{
		 int maxNumber = 10; 
		 int previousNumber = 0;
		 int nextNumber = 1;
		 for (int i = 1; i <= maxNumber; ++i)
	        {
	            System.out.print(previousNumber+" ");
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;
	        }
	}

	public static void main(String[] args) {
		int n = 6;
		String series = "";
		for (int i = 1; i <= n; i++) {
			int val = getFibonacciRecursion(i);
			series += val;
			System .out.println("Fibonacci of "+ i +" using recursion is : " + val );
		}
		System .out.println("Fibonacci series of "+ n +"  using recursion is : " + series );
		System .out.println("Fibonacci of using Iteration is : " );
		 getFibonacciIterative(n);
	}

}
