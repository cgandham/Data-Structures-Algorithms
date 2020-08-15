/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
import java.util.Stack;
public class InfixToPostfix {
	static Stack<String> stack = new Stack<>(); 
    static String result = new String(""); 
	static int getPriority(String ch) 
    { 
        switch (ch) 
        { 
        case "+": 
        case "-": 
            return 1; 
        case "*": 
        case "/": 
            return 2; 
        case "^": 
            return 3; 
        } 
        return -1; 
    } 
	static String evaluation(String c)
	{
		// If operand, add it to output. 
        if (c.chars().allMatch( Character::isDigit ))// Character.isLetterOrDigit(c) 
            result += c; 
           
        // If'(', push to stack. 
        else if (c.equals("("))
            stack.push(c); 
          
        //  If ')', pop and output from the stack  
        // until an '(' is encountered. 
        else if (c.equals(")")) 
        { 
            while (!stack.isEmpty() && !stack.peek().equals("(")) 
                result += stack.pop(); 
              
            if (!stack.isEmpty() && !stack.peek().equals("(")) 
                return "Invalid Expression"; // invalid expression                 
            else
                stack.pop(); 
        } 
        else // an operator is encountered 
        { 
            while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())){ 
                if(stack.peek().equals("(")) 
                    return "Invalid Expression"; 
                result += stack.pop(); 
            } 
            stack.push(c); 
        }
        return "Done Evaluating";
	}
	static String infixToPostfix(String expression) 
    { 
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
		
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.peek().equals("(")) 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
        return result; 
    } 
	
	public static void main(String[] args) {
		String exp = "(1+3+((4/2)*(8*4)))"; 
        System.out.println(infixToPostfix(exp)); 

	}

}
