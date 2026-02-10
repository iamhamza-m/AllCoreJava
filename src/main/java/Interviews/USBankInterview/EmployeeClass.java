package Interviews.USBankInterview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Employee class with methods for calculations like average salary, least paid, oldest, etc.
 */
public class EmployeeClass {
	private String name;
	private int age;
	private int salary;
	private String email;
	
	public EmployeeClass(String name, int age, int salary, String email) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "EmployeeClass{" +
					   "name='" + name + '\'' +
					   ", age=" + age +
					   ", salary=" + salary +
					   ", email='" + email + '\'' +
					   '}';
	}
}

class EmployeeMethods {
	public static void calculateSalaryAverage(List<EmployeeClass> employees) {
		double average = employees.stream().mapToInt(EmployeeClass::getSalary).average().orElse(0);
		System.out.println("Average salary: " + average);
	}
	
	public static void leastPaidEmployee(List<EmployeeClass> employees) {
		EmployeeClass least = employees.stream().min(Comparator.comparingInt(EmployeeClass::getSalary)).orElse(null);
		System.out.println("Least paid: " + (least != null ? least.getName() : "None"));
	}
	
	public static void oldestEmployee(List<EmployeeClass> employees) {
		EmployeeClass oldest = employees.stream().max(Comparator.comparingInt(EmployeeClass::getAge)).orElse(null);
		System.out.println("Oldest: " + (oldest != null ? oldest.getName() : "None"));
	}
	
	public static void lengthiestName(List<EmployeeClass> employees) {
		EmployeeClass longestName = employees.stream().max(Comparator.comparingInt(e -> e.getName().length())).orElse(null);
		System.out.println("Longest name: " + (longestName != null ? longestName.getName() : "None"));
	}
	
	public static List<EmployeeClass>  orderBySalary(List<EmployeeClass> employees){
		return employees.stream()
					   .sorted(Comparator.comparingInt(EmployeeClass::getSalary).reversed())
					   .collect(Collectors.toList());
	}
}

class EmployeeMain {
	public static void main(String[] args) {
		List<EmployeeClass> EmployeeList = new ArrayList<>();
		EmployeeList.add(new EmployeeClass("Anu", 12, 1, "Anu@gmail.com"));
		EmployeeList.add(new EmployeeClass("Manu", 13, 2, "Manu@gmail.com"));
		EmployeeList.add(new EmployeeClass("Sanu", 14, 3, "Sanu@gmail.com"));
		EmployeeList.add(new EmployeeClass("Gunu", 15, 4, "Gunu@gmail.com"));
		EmployeeList.add(new EmployeeClass("Monu", 15, 5, "Monu@gmail.com"));
		EmployeeList.add(new EmployeeClass("Montyyio", 16, 6, "Monty@gmail.com"));
		EmployeeList.add(new EmployeeClass("Sunil", 17, 7, "Sunil@gmail.com"));
		
		EmployeeMethods.calculateSalaryAverage(EmployeeList);
		EmployeeMethods.leastPaidEmployee(EmployeeList);
		EmployeeMethods.oldestEmployee(EmployeeList);
		EmployeeMethods.lengthiestName(EmployeeList);
		
		System.out.println("The ordered list by employee salary is " + EmployeeMethods.orderBySalary(EmployeeList));
	}
}
