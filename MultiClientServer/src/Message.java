import java.util.ArrayList;

public class Message {

	ArrayList<String> q = new ArrayList<String>();
	
	public Message(){
		q.add("qwertyuiop");
		q.add("12345678910");
		
	}
	
	public String getMessage(){
		int i = (int) (Math.random() * q.size());
		return q.get(i);
	}
}
