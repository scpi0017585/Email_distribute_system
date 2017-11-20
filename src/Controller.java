/*
   * Controller.java
   *
   * This class analysis input, also create arrayList store the recipient and sender object. 
   *

*/


import java.util.*;
public class Controller {
	public static void main(String[] args){
		View view = new View();
		//System.out.println(view.preload());
	    String command;
	    String name;
	    String group;
	    String input;
	    String message;
	    boolean exists = false;
	    boolean flag = false;
	    int i = 0;
	    input = view.preload();
	    String[] array1 = new String[300];
	    array1 = input.split(",");
	    ArrayList<Object> senders = new ArrayList<Object>();
	    ArrayList<Object> recipients = new ArrayList<Object>();
	    ArrayList<String> all_groups = new ArrayList<String>();
 	    /*
 	     *   read the input from input.txt, get the name,group and text based on the command. 
 	     */
	    while (array1.length != i) {
	    	command = array1[i];
	    	//test
	        //System.out.println(command);
	    	
	        /*
	         *   subscribe command will Initialize recipient object and store name and group in recipient object 
	         *   
	         */
	    	if (command.equals("Subscribe") || command.equals("subscribe")) {
	    		name = array1[i+1];
	    		group = array1[i+2];
	    		i = i + 3;
	    		if (recipients.isEmpty()) {
	    			Recipient recipient = new Recipient(name, group);
	    			recipient.subscribe(group);
	    			recipients.add(recipient);
	    			//test
	    			//System.out.println("The " + name + " on the list now ");
	    		}
	    		else {
	    		if(!recipients.isEmpty()) {
	    			for(int index = 0; index < recipients.size();index++) {
	    				if((((Recipient) recipients.get(index)).get_name()).equals(name)) {
	    					((Recipient) recipients.get(index)).subscribe(group);
	    					exists = true;
	    				}
	    			}
	    		}
	    		if(exists == false) {
	    			Recipient recipient = new Recipient(name, group);
	    			recipient.subscribe(group);
	    			recipients.add(recipient);
	    			//test
	    			//System.out.println("The " + name + " on the list now ");
	    		}
	    		exists = false;
	    	 }
	    	}
	    	/*
	    	 *  register command will Initialize Sender object and store name and group in Sender object
	    	 */
	    	else if (command.equals("Register")|| command.equals("register")) {
	    		
	    		name = array1[i+1];
	    		group = array1[i+2];
	    		i = i + 3;
	    		if(senders.isEmpty()) {
	    		Sender sender = new Sender(name,group);
	    		sender.register(group);
	    		all_groups.add(group);
	    		senders.add(sender);
	    		}
	    		else {
	    			for(int index = 0; index < senders.size(); index++) {
	    				if((((Sender) senders.get(index)).get_name()).equals(name)) {
	    					((Sender) senders.get(index)).register(group);
	    					all_groups.add(group);
	    					exists = true;
	    				}
	    			}
	    			if(exists == false ) {
	    				Sender sender = new Sender(name,group);
	    	    		sender.register(group);
	    	    		all_groups.add(group);
	    	    		senders.add(sender);
	    			}
	    		}
	    		exists = false;
	    	}
	    	/*
	    	 *    unsubscribe command will remove group on the recipient list. 
	    	 */
	    	else if (command.equals("Unsubscribe") || command.equals("unsubscribe")) {
	    		name = array1[i+1];
	    		group = array1[i+2];
	    		i = i + 3;
	    		if (recipients.isEmpty()) {
	    			//test debug use
	    			System.out.println("error 3, no recipients found");
	    		}
	    		if (!recipients.isEmpty()) {
	    			for(int index = 0; index < recipients.size(); index++) {
	    				if((((Recipient) recipients.get(index)).get_name()).equals(name)) {
	    					((Recipient) recipients.get(index)).unsubscribe(group);
	    				}
	    			}
	    		
	    	  }
	    	 
	    		
	    	}
	    	/*
	    	 *   send command 
	    	 */
	    	else if (command.equals("Send") || command.equals("send")) {
	    		name = array1[i+1];
	    		group = array1[i+2];
	    		message = array1[i+3];
	    		i = i + 4;
	    		for (int index = 0; index < all_groups.size(); index++) {
	    			if(all_groups.get(index).equals(group)) {
	    				exists = true;
	    			}
	    		}
	    		if(exists == false ) {
	    			System.out.println("Unauthorized publication by " + name);
	    			flag = true;
	    		}
	    		exists = false;
	    		
	    		if(!senders.isEmpty()&&!recipients.isEmpty()&& flag == false) {
	    		
	    			for(int index = 0; index < recipients.size();index++) {
	    				if( (((Recipient) recipients.get(index)).search(group) == true )) {
	    					for(int j = 0; j < senders.size(); j++) {
	    						if((((Sender) senders.get(j)).get_name()).equals(name)) {
	    							System.out.print(((Recipient) recipients.get(index)).get_name());
	    							((Sender)senders.get(j)).send_email(group,message);
	    							//test 
	    							((Recipient) recipients.get(index)).message.add(message);
	    						}
	    					}
	    				}
	    			}
	    		}
	    		flag = false;
	    	}
	    	else {
	    		//test debug use
	    		System.out.println(command);
	    		System.out.println("error 1");
	    	
	    	}
	    }
	    
	}
}
