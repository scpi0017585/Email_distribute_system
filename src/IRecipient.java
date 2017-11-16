
public interface IRecipient {
   
   public void subscribe(String group);
   
   public void unsubscribe(String group);
   
   public String get_name();
}
