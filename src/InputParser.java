/*
 *   InputParser.java
 *   posting id:1204-446
 *   InputParser will parser the input that read from CommandReader, and based on command take actions. 
 */
// forward engineering 
//begin
/*
 * public class InputParser {

	private String command;

	private String name;

	private String group;

	private String message;

	private String input;

	private boolean exists;

	private boolean flag;

	private int i;

	private ArrayList<object> recipients;

	private ArrayList<object> Sebders;

	private ArrayList<String> all_groups;

	private String[] array1;

	public InputParser(String[] input) {

	}

	public void ParseringInput() {

	}

}
 */
//end
import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {
	
	    /**
	     *   declare all variables
	     */
	    
	    String command;
	    String name;
	    String group;
	    String input;
	    String message;
	    boolean exists = false;
	    boolean flag = false;
	    int i = 0;
	    String[] array1 = new String[300];
	    ArrayList<Object> senders = new ArrayList<Object>();
	    ArrayList<Object> recipients = new ArrayList<Object>();
	    ArrayList<String> all_groups = new ArrayList<String>();
	 
	   /**
	    *  Constructor          
	    * @param array1
	    */
	    
	  public InputParser(String[] array1) {
		 this.array1 = array1;
	 }
	  /**
	   *   Parsering input and take action 
	   */
	  public void ParseringInput() {
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
	    				if((((Recipient) recipients.get(index)).get_name()).equalsIgnoreCase(name)) {
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
	    				if((((Sender) senders.get(index)).get_name()).equalsIgnoreCase(name)) {
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
	    				if((((Recipient) recipients.get(index)).get_name()).equalsIgnoreCase(name)) {
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
	    			if(all_groups.get(index).equalsIgnoreCase(group)) {
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
	    						if((((Sender) senders.get(j)).get_name()).equalsIgnoreCase(name)) {
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
	    		//System.out.println(command);
	    		//System.out.println("error 1");
	    		System.exit(0);
	    	}
	    }

}    
}
	    




