/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
import java.util.Stack;
//import org.apache.commons.lang.ArrayUtils;

public class MyStack {
	   
	   public static String sentence = "It was the best of time";
	   private int maxSize;
	   private static String[] stackArray;
	   private int top;
	   
	   public MyStack(int s) {
	      maxSize = s;
	      stackArray = new String[maxSize];
	      top = -1;
	   }
	   
	   public void push(String j) {
		   ++top;
		   stackArray[top] = j;
	      //stackArray[++top] = j;
	   }
	   public String pop() {
		  // ArrayUtils.removeElement(array, element)
	      return stackArray[top--];
	   }
	   public String peek() {
	      return stackArray[top];
	   }
	   public boolean isEmpty() {
	      return (top == -1);
	   }
	   public boolean isFull() {
	      return (top == maxSize - 1);
	   }
	   public void printStack() {
		  if(isEmpty())
			  return;
		  for (String s : MyStack.stackArray) {
				 if(s != null)
				 System.out.println(s); 
			} 
	   }
	public static void main(String[] args) {
		
		String[] array = sentence.split(" ");
		Stack<String> stack = new Stack<String>(); 
		System.out.println("Pushed sentence to stack");
		for (String element : array) {
			stack.push(element);
		}
		System.out.println(stack.toString());
		
		/*
		 * Stack<String> stack2 = new Stack<String>(); while(!stack.isEmpty()) {
		 * stack2.push(stack.pop()); }System.out.println(stack2.toString());
		 */
		  MyStack theStack = new MyStack(array.length);
		  System.out.println("\nPoped all elements to another stack which is using array");
		  while(!stack.isEmpty()) {
			  theStack.push(stack.pop());
			}
		  
		  System.out.println("\nReading elements from new stack, from behind, \norder does not change\n");
		 while(!theStack.isEmpty()) {
		  
			 System.out.println(theStack.pop()); 
		  }
		 
		
		  //System.out.println("\nOrder of stack\n");
		  //theStack.printStack();
		  
		  //System.out.println(stack.toString());
		
	}

}
