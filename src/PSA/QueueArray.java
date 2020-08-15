/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
import java.util.NoSuchElementException;
public class QueueArray {
	private int maxSize,rear,front;
	private String[] queue;
	QueueArray(int s){
		 maxSize = s;
	     queue = new String[maxSize];
	     rear = front = 0;
	}
	public void enqueue(String str)
	{
		if (maxSize == rear) { 
            System.out.println("\nQueue is full\n"); 
            return; 
        } 
		else { 
            queue[rear] = str; 
            rear++;
        } 
        return; 
	}
	
	public void dequeue() 
	{
		// If queue is empty, return. 
        if (front == rear) 
            return;
        for (int i = 0; i < rear - 1; i++) { 
            queue[i] = queue[i + 1]; 
        } 
        // store 0 at rear indicating there's no element 
        if (rear < maxSize) 
            queue[rear] = ""; 
        rear--; 
	}
	public boolean isFull()
	{
		return rear == maxSize;
	}
	public boolean isEmpty()
	{
		return front == rear;
	}
	public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return queue[front];
    }
	public void display() 
    { 
        if (front == rear) { 
            System.out.println("\nQueue is Empty\n"); 
            return; 
        } 
        for (int i = front; i < rear; i++) { 
            System.out.println(queue[i]); 
        } 
        return; 
    } 
	public static void main(String[] args) {
		QueueArray q = new QueueArray(10);
		q.enqueue("hi");
		q.enqueue("there");
		q.enqueue("sup?");
		q.dequeue();
		q.display();
	}
}
 