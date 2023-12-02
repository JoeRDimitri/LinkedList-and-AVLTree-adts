
public class Student {
	
	private long key = 0;
	private String value = "";
	
	public Student() {
		
	}
	
	public Student (int newkey, String newvalue) {
		this.key = newkey;
		this.value = newvalue;
	}
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String name) {
		this.value = name;
	}
	
	public long getKey() {
		return this.key;
	}
	
	public void setKey(long newkey) {
		this.key = newkey;
	}

	

}
