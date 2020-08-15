/**
 * Chandana Sri Gandham
 * NU ID: 001069916
 */
package PSA;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Comparable<User>{ 
	private String name; 
	private int id; 
	private Date birth; 

	public User (String name, int id, java.util.Date date) 	
		{ this.name = name; this.id = id; this.birth = (Date) date; } 

	@Override 
	public boolean equals(Object other){ 
		if(this == other) return true; 
		if(other == null || (this.getClass() != other.getClass()))
			{ return false; } 

		User guest = (User) other; 
			return(this.id == guest.id) && 
				(this.name != null && name.equals(guest.name)) && 
				(this.birth != null && birth.equals(guest.birth)); 
} 

@Override 	
	public int hashCode(){ 
		int result = 0; 
		result = 31*result + id; 
		result = 31*result + (name !=null ? name.hashCode() : 0); 
		result = 31*result + (birth !=null ? birth.hashCode() : 0); 
		return result; 
	} 


@Override 
	public int compareTo(User o) { 
		return this.id - o.id; }
public static void main(String[] args) {
	String pattern = "MM-dd-yyyy";
	   SimpleDateFormat format = new SimpleDateFormat(pattern);
	Date date = null;
	try {
	     date = format.parse("11-10-1997");
	     System.out.println(date);
	   } catch (ParseException e) {
	     e.printStackTrace();
	   }
	User user= new User("neeha", 1, date);
	int result = user.hashCode();
	System.out.println(result);
	
}
 }

