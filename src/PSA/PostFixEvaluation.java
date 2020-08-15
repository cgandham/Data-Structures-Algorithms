/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 * Post Fix Evaluation
 */

package PSA;
import java.util.Stack;
public class PostFixEvaluation {
	static Stack<Integer> stack = new Stack<Integer>();
	public static int evaluatePostFix(String expression) {
		if(expression.contains(" "))//if input contains space
		{
			String[] exp = expression.split("\\s+");
			for (String c : exp) {
				evaluation(c);
			}
		}
		else//looping through charectors
		{
			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);
				evaluation(Character.toString(c));
			}
		}
		return stack.pop();
	}
	private static void evaluation(String c) {
		if(c.chars().allMatch( Character::isDigit ))//Character.isDigit(c)
		{
			stack.push(Integer.parseInt(c));
		}
		else
		{
			int val1 = 0,val2 = 0;
			if (!stack.isEmpty()) {
				val1 = stack.pop();
			    val2 = stack.pop();
			}
			switch(c)
			{
			  case"+":
				  stack.push(val2 + val1);
				  break;
			  case"-":
				  stack.push(val2 - val1);
				  break;
			  case"*":
				  stack.push(val2 * val1);
				  break;
			  case"/":
				  stack.push(val2 / val1);
				  break;
			 /* * case')': case'(': ; * break; */
			}
		}
	}
	public static void main(String[] args) {
		String exp = "48+65-*32-22+*/";
		int result = evaluatePostFix(exp);
		System.out.println("\n"+exp + " --> " + result);
		
		exp = "1342/84**++";
	    result = evaluatePostFix(exp);
		System.out.println("\n"+exp + " --> " + result);
		
		exp ="1 2 20 5 / * +";
	    result = evaluatePostFix(exp);
		System.out.println("\n"+exp + " --> " + result);
	}
}
