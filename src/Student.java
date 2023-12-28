
public class Student {
	
	private String key = "0";
	private String value = "";
	
	public Student() {
		
	}

	public Student(Student s) {
		this.key = s.getKey();
		this.value = s.getValue();
		
	}
	
	public Student(String keyvalue) {
		this.key = keyvalue;
		this.value = "johndoe";
	}
	
	public Student (String newkey, String newvalue) {
		this.key = newkey;
		this.value = newvalue;
	}
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String name) {
		this.value = name;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public void setKey(String newkey) {
		this.key = newkey;
	}
	
	public String toString() {
		return this.value;
	}

	

}
