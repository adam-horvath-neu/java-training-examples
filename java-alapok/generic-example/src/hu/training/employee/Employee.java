package hu.training.employee;

import java.io.Serializable;

public class Employee implements Serializable, Comparable<Employee> {

	private static final long serialVersionUID = 1665777852415453038L;
	
	private String name;
	private int age;
	private Gender gender;

	public Employee(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public static enum Gender {
		MALE, FEMALE
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}

}
