/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class StackLinkedList {
	
	private static Node top;
	private class Node
	{
		String data;   
		Node next; 
    }
	
	StackLinkedList()
	{ 
		StackLinkedList.top = null; 
	}
	 
	public boolean isEmpty() 
    { 
        return top == null; 
    } 
	
	public String peek() 
    { 
        if (!isEmpty()) { 
            return top.data; 
        } 
        else { 
            System.out.println("Stack is empty"); 
            return null; 
        } 
    } 
	
	public void push(String str)
	{
		Node node = new Node();
		node.data = str;
		node.next = top;
		top = node;
		/*
		 * if(top == null) { top = new Node(); top.data = str; top.next = null; } else {
		 * Node temp = top; top.data = str; top.next = temp; }
		 */
	}
	
	public void pop() 
    { 
        if (top == null) { 
            System.out.print("\nStack Underflow"); 
            return; 
        } 
  
        // update the top pointer to point to the next node 
        System.out.print("\nPOPPING ELEMENT\n"+ top.data); 
        top = (top).next; 
    } 
	
	public void display() 
    { 
        if (top == null) { 
            System.out.println("\nStack Underflow"); 
        } 
        else { 
            Node temp = top; 
            System.out.println("ORDER OF STACK"); 
            while (temp != null) { 
                System.out.println(temp.data + "->"); 
                temp = temp.next; 
            } 
        } 
    } 
	
	

	public static void main(String[] args) {
		Scanner s;
		StackLinkedList myStack = new StackLinkedList();
		try { 
			s = new Scanner(new File("C://home/chandana/eclipse-workspace/Data Structures & Algorithms/src/PSA/input.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()){
			    list.add(s.next());
			}
			s.close();
			
			System.out.println("Pushing 3 elements into stack");
			//pushing 3 elements into stack
			for (int i=0;i<3;i++) {
				myStack.push(list.get(i));
				//System.out.println(l);
			}
			myStack.display();
			
			System.out.println("\nPoping 3 elements from stack");
			myStack.pop();
			myStack.pop();
			myStack.pop();
			
			System.out.println("\nPushing all elements into stack");
			for (int i=0;i<list.size();i++) {
				myStack.push(list.get(i));
			}
			myStack.display();
			
			System.out.println("\nPoping all elements into stack");
			while(top != null)
				myStack.pop();
			
			
			System.out.println("\nORIGINAL ORDER");
			for (String l : list) {
				System.out.println(l);
			}
			
			System.out.println("\nPushing all elements into stack");
			System.out.println("\nREVERSE ORDER");
			for (int i=0;i<list.size();i++) {
				myStack.push(list.get(i));
			}
			myStack.display();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
