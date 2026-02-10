package Interviews;

import java.util.*;
import java.util.stream.Collectors;


/// Question No.1

class Employee {
	private final int id;
	private final String name;
	private final int salary;
	private final int departmentId;
	
	public Employee( int id,String name, int salary, int departmentId)  {
		this.salary = salary;
		this.name = name;
		this.id = id;
		this.departmentId = departmentId;
	}
	
	// getters
	public String getName() { return name; }
	public int getDepartmentId() { return departmentId; }
	
	public int getSalary() {
		return salary;
	}
}

class Department {
	private final int departmentId;
	private final String depName;
	
	public Department(int departmentId, String depName) {
		this.depName = depName;
		this.departmentId = departmentId;
	}
	
	// getters
	public int getDepartmentId() { return departmentId; }
	public String getDepName() { return depName; }
}

class Interview {
	static void main(String[] args) {
		
		List<Department> departmentList = List.of(
				new Department(1, "HR"),
				new Department(2, "IT"),
				new Department(3, "Finance")
		);
		
		List<Employee> employeeList = List.of(
				new Employee(101, "John", 50000, 2),
				new Employee(102, "Alice", 70000, 1),
				new Employee(103, "Bob", 45000, 3),
				new Employee(104, "Charlie", 60000, 2),
				new Employee(105, "David", 45000, 1)
		);
		
		Map<Integer, String> departmentMap = new LinkedHashMap<>();
		
		departmentList.forEach(item -> departmentMap.put(item.getDepartmentId(), item.getDepName()));
		
		employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary))
				.forEach(e ->
								 System.out.println(
										 e.getName() + "     " +
												 e.getSalary() + " " +
												 departmentMap.get(e.getDepartmentId())
								 )
				);
		
		
	}
}


/// Question No.2

class StringCheck {
	static void main(String[] args) {
		String s1 = "The swimming pool was new and this pool was inaugurated in year 1998. The pool plays an essential role in our lives";
		String s2 = "pool";
		
		String[] returned = s1.split(" ");
		
		int count = 0;
		
		for(int i=0; i < returned.length; i++){
			if(returned[i].equals(s2)){
				count++;
			}
		}
		
		System.out.printf("The given string appeared %d times", count);
		
	}
}


/// Question No.3

class SingletonImplementation{
	
	private static SingletonImplementation instance;
	
	 private SingletonImplementation(){
		System.out.println("The instance has been created");
	}
	
	public static SingletonImplementation getInstance(){
		if(instance == null){
			instance = new SingletonImplementation();
		}
		
		return instance;
	}
	
}

class SingletonUsage{
	static void main(String[] args) {
		SingletonImplementation s1 = SingletonImplementation.getInstance();
		SingletonImplementation s2 = SingletonImplementation.getInstance();
		
		System.out.println(s1 == s2);
	}
}
