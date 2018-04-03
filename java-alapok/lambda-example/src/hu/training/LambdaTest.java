package hu.training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import hu.training.employee.Employee;
import hu.training.employee.Student;

public class LambdaTest {

	public static void main(String[] args) {

		// Referencing to the System.out's (PrintWriter.write()) write method. The write
		// method
		// will be called with the given value in the accept method.
		Consumer<String> c = System.out::println;
		c.accept("This is just the begining.");

		Collection<Student> students = new ArrayList<>();
		students.add(new Student("Béla", 26));
		students.add(new Student("Guszti", 21));
		students.add(new Student("József", 32));
		students.add(new Student("Kristóf", 23));

		// Student older than 25 will be filtered into a new list
		System.out.println("\n----- Filtered list -----");
		List<Student> olderStudents = students.stream().filter(student -> student.getAge() > 25)
				.collect(Collectors.toList());
		System.out.println(olderStudents);

		// First students who is older then 25 will be selected
		System.out.println("\n----- Find first -----");
		Student firstOlderStudents = students.stream().filter(student -> student.getAge() > 25).findFirst().get();
		System.out.println(firstOlderStudents);

		// In the map method, the student will be converted into String via its
		// toString() method, and this String will printed out to the console
		System.out.println("\n----- Map to string -----");
		students.stream().map(Student::toString).forEach(System.out::println);

		// Map from student to employee
		System.out.println("\n----- Mapping with explicit constructor call -----");
		List<Employee> employees = students.stream().map(student -> new Employee(student.getName(), student.getAge()))
				.collect(Collectors.toList());
		System.out.println(employees);

		// Map from student to employee - in the map method, the Employee class
		// constructor with the student parameter will be called. Method reference.
		System.out.println("\n----- Mapping with method reference -----");
		employees = students.stream().map(Employee::new).collect(Collectors.toList());
		System.out.println(employees);

		// Is present - 2 different way
		System.out.println("\n----- Is present -----");
		boolean isBelaPresent = students.stream().anyMatch(student -> student.getName().equals("Béla"));
		System.out.println("Is present Bela?: " + isBelaPresent);
		boolean isArpadPresent = students.stream().filter(student -> student.getName().equals("Árpád")).findAny()
				.isPresent();
		System.out.println("Is present another way Arpad?: " + isArpadPresent);

		// Sorted with Comparable interface implemented in Student
		System.out.println("\n----- Sort with Comparable -----");
		students.stream().sorted().forEach(System.out::println);

		// Sorted with Comparator interface implemented with lambda expression
		System.out.println("\n----- Sort with Comparator interface -----");
		students.stream().sorted((student1, student2) -> student1.getAge() - student2.getAge()).forEach(System.out::println);

		// Reduce - Summarize the age of the students
		// 0 - a kezdõ érték, illetve a default érték, ha üres a kollekció
		// a - az addigi elemek összege
		// b - az aktuális elem
		System.out.println("\n----- Reduce -----");
		Integer totalAgeReduce = students.stream().map(Student::getAge).reduce(0, (a, b) -> a + b);
		System.out.println("Avarage age: " + ((double) totalAgeReduce) / students.size());

		// Parallel - check the order of the result
		System.out.println("\n----- Parallel stream -----");
		students.parallelStream().forEach(System.out::println);
	}
}
