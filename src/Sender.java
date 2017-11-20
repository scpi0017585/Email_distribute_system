/*
   * Sender.java
   *
   * Sender class implements ISender interface, It have arrayList groups that store register group read from
   * input.txt in Controller class. 
   *

*/


import java.util.*;
public class Sender implements ISender {
	
	String sender;
	String group;
	boolean exists = false;
	ArrayList<String> groups = new ArrayList<String>();
	 public Sender(String sender, String group) {
		 this.sender = sender;
		 this.group = group;
	 }
	 public void register(String group) {
		 if(groups.isEmpty()) {
			   groups.add(group);
			   //test
			   //System.out.println("group: "+ group + "\tregisted! ");
		 }
		 else {
	     for(int index = 0; index < groups.size(); index++) {
	    	 if(groups.get(index).equals(group)) {
	    		 exists = true;
	    	 }
	     }
	     if(exists == false) {
	    	 groups.add(group);
	    	 //test
	    	 //System.out.println("group: "+ group + "\tregisted! ");
	     }
		 }
		 exists = false;
	 }
	   /*
	    * (non-Javadoc)
	    * @see ISender#send_email(java.lang.String, java.lang.String)
	    *   send_email send the notifications.
	    */
	   public void send_email(String group,String text) {
		   for(int index = 0; index < groups.size(); index++) {
			   if(groups.get(index).equals(group)) {
				   exists = true;
			   }
		   }
		  if(!groups.isEmpty() && exists == true) {
			  System.out.print(" received email from " + sender + " " + text + "\n");
	      }
		  //test
		  else {
			  System.out.println("cannot recived email, due to unauthorized publication by " + get_name());
		  }
		  exists = false;
	 }
	   public String get_name() {
		   return sender;
	   }
	   
	   public boolean search_group(String group) {
		   for(int index = 0; index < groups.size(); index++) {
		    	 if(groups.get(index).equals(group)) {
		    		return true;
		    	 }
		    
	   }
		   return false;
}
}
