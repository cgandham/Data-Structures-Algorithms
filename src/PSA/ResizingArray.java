/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
public class ResizingArray {
	 private int maxSize;
	   private static String[] stackArray;
	   private int top;
	   
	   public ResizingArray(int s) {
	      maxSize = s;
	      stackArray = new String[maxSize];
	      top = -1;
	   }
	   
	   public void push(String j) {
		   ++top;
		   if(top == maxSize)resize(maxSize * 2);
		   stackArray[top] = j;
	      //stackArray[++top] = j;
	   }
	   public String pop() {
		  // ArrayUtils.removeElement(array, element)
	       String pop = stackArray[top--];
	       if(top>0 && top == maxSize /4) resize(maxSize/2);
	       return pop;
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
		  System.out.println("Printing bottom to top");
		  for (String s : ResizingArray.stackArray) {
				 if(s != null)
				 System.out.println(s); 
			} 
	   }
	   public void resize(int size) {
		   if(size <= 0)
			   return;
		   String[] newArray = new String[size];
		   for (int i = 0; i < ResizingArray.stackArray.length; i++) {
			  newArray[i] = stackArray[i];
		   }
		   stackArray = newArray;
	   }
	   
	   public static void main(String[] args) {
		   ResizingArray stack = new ResizingArray(5);
		   stack.push("1");
		   stack.push("2");
		   stack.push("3");
		   stack.push("4");
		   stack.push("5");
		   stack.pop();
		   stack.push("6");
		   stack.printStack();
		   
	   }
}
