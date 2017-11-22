/*
   * Controller.java
   *
   *posting ID: 1204-446
   * This class analysis input, also create arrayList store the recipient and sender object. 
   *

*/
//Forward Engineering 
//begin
//
/*public class Controller {

	public void main(String[] args) {

	}

} */
//end

import java.util.*;
public class Controller {
	public static void main(String[] args){
		String input = "";
		String[] array1 = new String[300];
		CommandReader commandreader = new CommandReader();
		//input = commandreader.preload();
		input = commandreader.input();
		while (input != "") {
		array1 = input.split(",");
		InputParser inputparser = new InputParser(array1);
		inputparser.ParseringInput();
		input = commandreader.input();
       }
}
}