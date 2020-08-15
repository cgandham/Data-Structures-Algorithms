/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;

public class countStringBinary {
	
		public static int countStrings(int n, int lastDigit)
		{
			if (n == 0) {
				return 0;
			}

			if (n == 1) {
				return (lastDigit == 1) ? 1: 2;
			}

			if (lastDigit == 0) {
				return countStrings(n - 1, 0) + countStrings(n - 1, 1);
			}
			
			else {
				return countStrings(n - 1, 0);
			}
		}

	public static void main(String[] args) {
		int n = 4;

		System.out.println(countStrings(n, 0));
	}

}
