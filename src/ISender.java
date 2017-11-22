/*
 *  ISender.java
 *  posting ID:1204-446
 *  Interface
 */
//begin
/*
 public interface ISender {

	public abstract void register(String group);

	public abstract void send_email(String group, String text);

	public abstract String get_name();

}
 */
//end
public interface ISender {
   public void register(String group);
   
   public void send_email(String group,String text);
   
   public String get_name();
}
