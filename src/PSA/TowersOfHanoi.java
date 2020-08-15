/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;

public class TowersOfHanoi {
	class Stack 
    { 
        int capacity; 
        int top; 
        int array[]; 
    } 
	Stack createStack(int capacity) 
    { 
        Stack stack=new Stack(); 
        stack.capacity = capacity; 
        stack.top = -1; 
        stack.array = new int[capacity]; 
        return stack; 
    } 
     
	static boolean isFull(Stack stack) 
    { 
        return (stack.top == stack.capacity - 1); 
    } 
	
    static boolean isEmpty(Stack stack) 
    { 
        return (stack.top == -1); 
    } 
    
    static void push(Stack stack,int item) 
    { 
        if(isFull(stack)) 
            return; 
        stack.array[++stack.top] = item; 
    } 
    
    static int pop(Stack stack) 
    { 
        if(isEmpty(stack)) 
            return Integer.MIN_VALUE; 
        return stack.array[stack.top--]; 
    } 
	
	public static void moveDisksBtwTwoPoles(Stack src, Stack dest, char s, char d) {
		int pole1TopDisk = pop(src); 
		int pole2TopDisk = pop(dest); 

		if (pole1TopDisk == Integer.MIN_VALUE)  
		{ 
		    push(src, pole2TopDisk); 
		    moveDisk(d, s, pole2TopDisk); 
		} 

		else if (pole2TopDisk == Integer.MIN_VALUE)  
		{ 
		push(dest, pole1TopDisk); 
		moveDisk(s, d, pole1TopDisk); 
		} 

		else if (pole1TopDisk > pole2TopDisk)  
		{ 
		push(src, pole1TopDisk); 
		push(src, pole2TopDisk); 
		moveDisk(d, s, pole2TopDisk); 
		} 

		else 
		{ 
		push(dest, pole2TopDisk); 
		push(dest, pole1TopDisk); 
		moveDisk(s, d, pole1TopDisk); 
		} 
	}
	
	
	public static void moveDisk(char fromPeg, char toPeg, int disk) 
    { 
        System.out.println("Move the disk "+disk +  
                        " from "+fromPeg+" to "+toPeg); 
    } 
	
    public void tohIterative(int num_of_disks, Stack  src, Stack aux, Stack dest) 
    { 
    int i, total_num_of_moves; 
    char s = 'S', d = 'D', a = 'A'; 
   
    if (num_of_disks % 2 == 0) 
    { 
        char temp = d; 
        d = a; 
        a  = temp; 
    } 
    total_num_of_moves = (int) (Math.pow(2, num_of_disks) - 1); 
   
    for (i = num_of_disks; i >= 1; i--) 
        push(src, i); 
   
    for (i = 1; i <= total_num_of_moves; i++) 
    { 
        if (i % 3 == 1) 
        	moveDisksBtwTwoPoles(src, dest, s, d); 
   
        else if (i % 3 == 2) 
        	moveDisksBtwTwoPoles(src, aux, s, a); 
   
        else if (i % 3 == 0) 
        	moveDisksBtwTwoPoles(aux, dest, a, d); 
    } 
} 
	
	public static void main(String[] args) {
		
        int noOfDisks = 5; 
          
        TowersOfHanoi ob = new TowersOfHanoi(); 
        Stack src, dest, aux; 
          
        src = ob.createStack(noOfDisks); 
        dest = ob.createStack(noOfDisks); 
        aux = ob.createStack(noOfDisks); 
          
        ob.tohIterative(noOfDisks, src, aux, dest); 

	}

}
