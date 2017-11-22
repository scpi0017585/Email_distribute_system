/*
 *  CommandReader.java 
 *  post id:1204-446
 *  Read Input form user.
 * 
 */
//Forward Engineering 
//begin
/*public class CommandReader {

	private Scanner scanner;

	private String input;
	public String reload() {
		return null;
	}
	public void input() {
	}
} */
//end
import java.io.InputStream;
import java.util.Scanner;

public class CommandReader {
	 Scanner scanner = new Scanner(System.in);
	   
	    String input = "";
	   //load the input.txt, currently disabled...
	   public String preload() {
	   InputStream is = this.getClass().getClassLoader().getResourceAsStream("input.txt");
	   Scanner s = new Scanner(is).useDelimiter("\\A");
	   String result = s.hasNext() ? s.next() : "";
	   s.close();
	   return result;
	   }
	   /**
	    *  takes user's input, no handling. 
	    * @return
	    */
	   public String input() {
		   input = scanner.nextLine();
		   return input;
	   }
}
