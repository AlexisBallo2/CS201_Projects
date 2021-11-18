import java.util.ArrayList;

public class Person {

	private ArrayList<String> friendsList = new ArrayList<String>();
	private String name; 
	private boolean explored = false;
	private String pred = "";
	
	public Person(String x) {
		this.name = x;
	}
	public Person() {
		
	}
	 
	public ArrayList<String> getFriendsList() {
		return this.friendsList;
	}
	
	
	public String getName() {
		return this.name;
	}
	public void setExplored(boolean x) {
		this.explored = x;
	}
	public boolean getExplored() {
		return this.explored;
	}
	public void setPred(String x) {
		this.pred = x;
	}
	public String getPred() {
		return this.pred;
	}
	
	public String toString() {
        return this.name;
   }
}
