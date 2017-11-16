import java.util.*;
public class Sender implements ISender {
	
	Scanner scanner = new Scanner(System.in);
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
			   System.out.println("group: "+ group + "\tregisted! ");
		 }
		 else {
	     for(int index = 0; index < groups.size(); index++) {
	    	 if(groups.get(index).equals(group)) {
	    		 exists = true;
	    	 }
	     }
	     if(exists == false) {
	    	 groups.add(group);
	    	 System.out.println("group: "+ group + "\tregisted! ");
	     }
		 }
		 exists = false;
	 }
	   
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
			  System.out.println("in send_email, no subscribe group found");
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
