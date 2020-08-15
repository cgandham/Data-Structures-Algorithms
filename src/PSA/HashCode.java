/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;

public class HashCode {
	public static int getHashCode(String input){
		return input.hashCode();
	}
	
    public static  int getHashCodeWithImplementation(String input){
    	int result = 0;
    	for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			int ascii = (int)ch;
			int power = (int) Math.pow(31, input.length()-i-1);
			result += (int)ascii*power;
			
		}
    	return result;
	}

	public static void main(String[] args) {
		String input = "Welcome Students to Class";
		System.out.println("Hashcode using BuiltIn method: " + getHashCode(input));
		System.out.println("Hashcode built with logic: " + getHashCodeWithImplementation(input));
		//int result;
		
	}

}
