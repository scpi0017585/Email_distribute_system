import java.util.*;

public class Recipient implements IRecipient {
	String list = "";
	String recipient;
    String group;
    boolean exists = false;
    ArrayList<String> subscribe_groups = new ArrayList<String>();
	public Recipient(String recipient,String group) {
	  this.recipient = recipient;
	  this.group = group;
	  
  }
  public void subscribe(String group) {
	  if(subscribe_groups.isEmpty()) {
		  subscribe_groups.add(group);
	  }
	 for (int index = 0; index < subscribe_groups.size(); index++) {
	  if(subscribe_groups.get(index).equals(group)) {
	   exists = true;
	   //test
	   System.out.println("you already subscribe " + group + " group ");
	    }
	 }
	 if(exists == false && !subscribe_groups.isEmpty()) {
		 subscribe_groups.add(group);
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
			  if(subscribe_groups.get(index).equals(group)) {
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