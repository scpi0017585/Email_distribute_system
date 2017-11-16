import java.util.*;
public class Controller {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		View view = new View();
		//System.out.println(view.preload());
	    String command;
	    String name;
	    String group;
	    String input;
	    String meassage;
	    boolean exists = false;
	    int i = 0;
	    input = view.preload();
	    String[] array1 = new String[300];
	    array1 = input.split(",");
	    ArrayList<Object> all_groups = new ArrayList<Object>();
	    ArrayList<Object> recipients = new ArrayList<Object>();
	    
	    while (array1.length != i) {
	    	command = array1[i];
	        System.out.println(command);
	    	
	    	if (command.equals("Subscribe") || command.equals("subscribe")) {
	    		name = array1[i+1];
	    		//do something
	    		group = array1[i+2];
	    		//do something
	    		i = i + 3;
	    		if (all_groups.isEmpty()) {
	    			System.out.println("error 2, no registed groups");
	    		}
	    		if (!all_groups.isEmpty()) {
	    			for(int index = 0; index < all_groups.size(); index++) {
	    				if((((Sender) all_groups.get(index)).get_group()).equals(group)) {
	    					exists = true;
	    				}
	    			}
	    		if(exists == true) {
	    			Recipient recipient = new Recipient(name, group);
	    			recipient.subscribe(group);
	    			recipients.add(recipient);
	    			
	    		}
	    	  }
	    	  exists = false;
	    		
	    	}
	    	else if (command.equals("Register")|| command.equals("register")) {
	    		
	    		name = array1[i+1];
	    		//doing something
	    		group = array1[i+2];
	    		//do something
	    		i = i + 3;
	    		if(all_groups.isEmpty()) {
	    		Sender sender = new Sender(name,group);
	    		sender.register(group);
	    		all_groups.add(sender);
	    		}
	    		else {
	    			for(int index = 0; index < all_groups.size(); index++) {
	    				if((((Sender) all_groups.get(index)).get_group()).equals(group)) {
	    				  exists = true;
	    				}
	    			}
	    			if(exists == false ) {
	    				Sender sender = new Sender(name,group);
	    	    		sender.register(group);
	    	    		all_groups.add(sender);
	    			}
	    		}
	    		exists = false;
	    	}
	    	else if (command.equals("Unsubscribe") || command.equals("unsubscribe")) {
	    		name = array1[i+1];
	    		//do something
	    		group = array1[i+2];
	    		//do something
	    		i = i + 3;
	    		if (recipients.isEmpty()) {
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
	    	else if (command.equals("Send") || command.equals("send")) {
	    		name = array1[i+1];
	    		//do something
	    		group = array1[i+2];
	    		//do something
	    		meassage = array1[i+3];
	    		//do something
	    		i = i + 4;
	    		if(!all_groups.isEmpty()&&!recipients.isEmpty()) {
	    			for(int index = 0; index < all_groups.size(); index++) {
	    				for(int j = 0; j < recipients.size(); j++) {
	    					if( (((Recipient) recipients.get(j)).search(((Sender) all_groups.get(index)).get_group()) == true )) {
	    						System.out.println(((Recipient) recipients.get(j)).get_name() + " received email from " + ((Sender) all_groups.get(index)).get_name() + " " + meassage );
	    					}
	    				}
	    			}
	    		}
	    	}
	    	else {
	    		System.out.println(command);
	    		System.out.println("error 1");
	    	
	    	}
	    }
	    
		 }
}
