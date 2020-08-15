/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package edu.neu.coe.info6205.functions;
import java.util.NoSuchElementException;

public class CircularQueue {
	int front,rear;
	static int maxSize;
	private int[] queue;
	
	CircularQueue(int size) {
		//int data;
		maxSize = size;
		queue = new int[maxSize]; 
		front = rear = -1;
	}
	
	public void enqueue(int data)
	{
		System.out.println("Enqueuing behind rear: "+data);
		//check if queue is full
		if((rear == maxSize-1 && front == 0) || (rear == front-1)) {
			System.out.println("Queue is full");
			return;
		}
		else if(front == -1) {
			queue[0] = data;
			rear = front = 0;
		}
		else if(rear == maxSize-1 && front != 0) {
			rear = 0;
			queue[rear] = data;
		}
		else
		{
			rear = rear + 1;
			queue[rear] = data;
		}
	}
	
	public void dequeue()
	{
		if(front == -1) {
			System.out.println("Queue is empty");
			return;
		}
		else if(front == rear) {
			System.out.println("Dequeue front element: "+queue[front]); 
			front = -1;
			rear = -1;
			 
		}
		else if (front == maxSize-1) {
			System.out.println("Dequeue front element: "+queue[front]); 
			front = 0; 
		}
	    else {
	    	System.out.println("Dequeue front element: "+queue[front]); 
	    	front++;
	    }
		  
	}
	
	public boolean isFull()
	{
		return (rear == maxSize-1 && front == 0) || (rear == front-1)? true:false;
	}
	public boolean isEmpty()
	{
		return front==-1 && rear ==-1? true: false;
	}
	
	public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return queue[front];
    }
	
	public void display() 
    { 
        if (front == -1) { 
            System.out.println("\nQueue is Empty\n"); 
            return; 
        } 
        
        System.out.println("Order of Queue:"); 
        for (int i = front; i < rear; i++) { 
            System.out.println(queue[i]); 
        } 
        return; 
    } 
	

	public static void main(String[] args) {
		int[] arr = new int[]{12, 17, 38, 3, 9, 82, 10, 31, 24, 31 };
		CircularQueue q = new CircularQueue(arr.length);
		for (int i = 0; i < arr.length; i++) {
			q.enqueue(arr[i]);
		}
		q.display();
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.display();
		
		q.enqueue(1);
		q.enqueue(2);
		q.display();
		
		for (int i = 0; i < maxSize-1; i++) {
			q.dequeue();
		}
		q.display();
		
		

	}

}
