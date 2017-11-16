import java.util.*;
public class Sender implements ISender {
	
	Scanner scanner = new Scanner(System.in);
	String sender;
	String group;
	boolean exists = false;
	ArrayList<String> groups = new ArrayList<String>();
	ArrayList<String> meassage = new ArrayList<String>();
	 public Sender(String sender, String group) {
		 this.sender = sender;
		 this.group = group;
	 }
	 public void register(String group) {
		 if(groups.isEmpty()) {
			   groups.add(group);
			   System.out.println("group: "+ group + "\tregisted! ");
		 }
	     for(int index = 0; index < groups.size(); index++) {
	    	 if(groups.get(index).equals(group)) {
	    		 exists = true;
	    	 }
	     }
	     if(exists == false) {
	    	 groups.add(group);
	    	 System.out.println("group: "+ group + "\tregisted! ");
	     }
	     exists = false;
	 }
	   
	   public void send_email(String group,String text) {
		  if(!groups.isEmpty()) {
			  for(int index = 0; index < groups.size(); index++) {
			    	 if(groups.get(index).equals(group)) {
			    		meassage.add(group);
			    		meassage.add(text);
			    	 }
			  }
	      }
		  //test
		  else {
			  System.out.println("send_email, no subscribe group found");
		  }
	 }
	   public String get_name() {
		   return sender;
	   }
	   public String get_group() {
		   return group;
	   }
}
