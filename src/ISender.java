
public interface ISender {
   public void register(String group);
   
   public void send_email(String group,String text);
   
   public String get_name();
}
