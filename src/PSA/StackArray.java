/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 * Implementing stack using array
 */



package PSA;
public class StackArray {
	
	   private int maxSize;
	   private static student[] stackArray;
	   private int top;
	   public static class student
	   {
		   int id;
		   String name;
		/*
		 * public student(int i, String string) { this.id = i; this.name = string; }
		 */
	   }
	   public StackArray(int s) {
	      maxSize = s;
	      stackArray = new student[maxSize];
	      top = -1;
	   }
	   
	   public void push(student j) {
		   student stu = new student();
		   stu.id = j.id;
		   stu.name = j.name;
		   ++top;
		   stackArray[top] = stu;
	      //stackArray[++top] = j;
	   }
	   public student pop() {
		
	      return stackArray[top--];
	   }
	   public student peek() {
	      return stackArray[top];
	   }
	   public boolean isEmpty() {
	      return (top == -1);
	   }
	   public boolean isFull() {
	      return (top == maxSize - 1);
	   }
	   public void printStack(StackArray stackArray) {
		  if(isEmpty())
			  return;
		  System.out.println("Elements in the stack:\n");
		 for (student student : StackArray.stackArray) {
			 if(student != null)
			 System.out.println("ID: "+student.id+" Name: "+student.name ); 
		} 
	   }
	public static void main(String[] args) {
		StackArray theStack = new StackArray(10);
		student stu = new student();
		stu.id = 31;stu.name = "AA";
		theStack.push(stu);
		stu.id = 24;stu.name = "BB";
		theStack.push(stu);
		stu.id = 10;stu.name = "CC";
		theStack.push(stu);
		stu.id = 44;stu.name = "DD";
		theStack.push(stu);
		stu.id = 81;stu.name = "EE";
		theStack.push(stu);
		theStack.printStack(theStack);
		System.out.println("\nTop of stack\n Id: " +  theStack.peek().id + " Name: " + theStack.peek().name); 
		student popped = theStack.pop();
		System.out.println("\nPoped from stack\n Id: " +  popped.id + " Name: " + popped.name); 
		}

}
