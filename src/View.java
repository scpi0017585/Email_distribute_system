/*
   * View.java
   *
   * This class reload the input.txt, and takes inputs from stdin redirecting the input to file.
   *

*/
import java.io.InputStream;
import java.util.*;
public class View {
   Scanner scanner = new Scanner(System.in);
   
   //reload the input.txt file
   public String preload() {
   InputStream is = this.getClass().getClassLoader().getResourceAsStream("input.txt");
   Scanner s = new Scanner(is).useDelimiter("\\A");
   String result = s.hasNext() ? s.next() : "";
   s.close();
   return result;
   }
}