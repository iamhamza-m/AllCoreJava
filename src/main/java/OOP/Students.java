package OOP;

/**
 * Simple Student class.
 */
public class Students {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Students(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Students{" +
					   "name='" + name + '\'' +
					   '}';
	}
}
