package hu.training.employee;

public class Employee implements Comparable<Employee> {

	private String name;
	private int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Employee(Student student) {
		super();
		this.name = student.getName();
		this.age = student.getAge();
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.age - o.getAge();
	}

}
