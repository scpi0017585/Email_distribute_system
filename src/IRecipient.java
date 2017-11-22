/*
 *   IRcipient.java
 *   posting id:1204-446
 *   interface 
 */
//begin
/*public interface IRecipient {

	public abstract void subscribe(String group);

	public abstract void unsubscribe(String group);

	public abstract String get_name();

}
 */
//end
public interface IRecipient {
   
   public void subscribe(String group);
   
   public void unsubscribe(String group);
   
   public String get_name();
}
