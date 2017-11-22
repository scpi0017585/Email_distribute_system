/*
   * Recipient.java
   *
   *posting id:1204-446
   * Recipient implements IRecipient interface, It have arrayList subscribe_groups that store subscribed groups read from
   * input.txt in Controller class. 
   *
*/
//begin
/*
public class Recipient implements IRecipient {

	private String recipient;

	private String group;

	private boolean exists;

	private ArrayList<String> subscribe_groups;

	private ArrayList<String> message;

	public Recipient(String recipient, String group) {

	}

	public void subscribe(String group) {

	}

	public void unsubscribe(String group) {

	}

	public boolean search(String group) {
		return false;
	}

	public String get_name() {
		return null;
	}

}
 */
//end
import java.util.*;

public class Recipient implements IRecipient {
	String recipient;
    String group;
    boolean exists = false;
    ArrayList<String> subscribe_groups = new ArrayList<String>();
    ArrayList<String> message = new ArrayList<String>(); 
	public Recipient(String recipient,String group) {
	  this.recipient = recipient;
	  this.group = group;
	  
  }
  public void subscribe(String group) {
	  if(subscribe_groups.isEmpty()) {
		  subscribe_groups.add(group);
	  }
	  else {
	 for (int index = 0; index < subscribe_groups.size(); index++) {
	  if(subscribe_groups.get(index).equals(group)) {
	   exists = true;
	   //test
	   //System.out.println("you already subscribe " + group + " group ");
	    }
	 }
	 if(exists == false) {
		 subscribe_groups.add(group);
	 }
	 }
	  exists = false;
  }
  
  public void unsubscribe(String group) {
	  if(!subscribe_groups.isEmpty()) {
		  for (int index = 0; index < subscribe_groups.size(); index++) {
			  if(subscribe_groups.get(index).equals(group)) {
				  subscribe_groups.remove(index);
			  }
		  }
	  }
	  //test
	  else {
		  System.out.println("no subscribe group found!");
	  }
  }
  
  public boolean search(String group) {
	  if(!subscribe_groups.isEmpty()) {
		  for (int index = 0; index < subscribe_groups.size(); index++) {
			  if(subscribe_groups.get(index).equalsIgnoreCase(group)) {
				  return true;
			  }
		  }
	  }
	  return false;
	  
  }
  
  public String get_name() {
	 return recipient;
  }
}