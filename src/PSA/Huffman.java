/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman {

	public static class Node{
		
		public int frequency;
		public char c;
		
		public Node left;
		public Node right;
		
	}
	
	public static class MyComparator implements Comparator<Node> { 
		
	    public int compare(Node x, Node y) 
	    { 
	        return x.frequency - y.frequency; 
	    } 
	    
	}
	
	public static void printCode(Node root, String binary) {
		//if leaf print
		if(root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + binary); 
			return;
		}
		//loops till end of the tree 
		printCode(root.left, binary + "0"); 
        printCode(root.right, binary + "1"); 
		
	}
	
	public static void main(String[] args) {
		String str = "This was hard quiz for students";
		//number of unique charectors in the string
		int n = 17; 
	    char[] charArray = { 'T', 'h', 'i', 's', ' ',
	            'w', 'a', 
	            'r', 'd', 
	            'q', 'u', 'z', 
	            'f', 'o', 
	            't', 'e', 'n' };
	    int[] charfreq = { 1, 2, 2, 4, 5, 1, 2, 2, 2,1,2,1,1,1, 2, 1,1};
		/*
		 * charArray = str.toCharArray();
		 * 
		 * HashSet<Character> uniqueCharSet = new HashSet<Character>(); for(char each :
		 * charArray){ if(each != ' ') uniqueCharSet.add(each); } HashSet<Integer>
		 * uniqueCharFreq = new HashSet<Integer>(); for(char each : uniqueCharSet){
		 * uniqueCharFreq.add((int) str.chars().filter(num -> num == each).count()); }
		 * 
		 * 
		 * for (int i = 0; i < str.length(); i++){ char c = str.charAt(i);
		 * if(!Arrays.asList(charArray).contains(c) && c != ' ') { charArray[i] = c;
		 * charfreq[i] = (int) str.chars().filter(num -> num == c).count(); } }
		 */
	    
	    
        PriorityQueue<Node> q 
        = new PriorityQueue<Node>(n, new MyComparator());
        
        for (int i = 0; i < n; i++) { 
        	
            Node hn = new Node(); 
  
            hn.c = charArray[i]; 
            hn.frequency = charfreq[i]; 
  
            hn.left = null; 
            hn.right = null; 
  
            q.add(hn); 
        } 
        
        Node root = null; 
        while (q.size() > 1) {
        	Node x = q.peek(); 
            q.poll(); 
            Node y = q.peek(); 
            q.poll(); 
            
            Node f = new Node();
            f.frequency = x.frequency + y.frequency; 
            f.c = '-'; 
            f.left = x; 
            f.right = y; 
            root = f; 
            q.add(f); 
        }
        printCode(root, ""); 

	}

}
