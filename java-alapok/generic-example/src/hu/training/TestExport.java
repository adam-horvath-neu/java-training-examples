package hu.training;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import hu.training.dog.Dog;
import hu.training.employee.Employee;
import hu.training.writer.CSVWriter;
import hu.training.writer.impl.DogCSVWriter;
import hu.training.writer.impl.EmployeeCSVWriter;

public class TestExport {

	public static void main(String[] args) throws IOException {
		Collection<Dog> dogs = new ArrayList<>();
		dogs.add(new Dog("Boomer", "Brown", Dog.Type.VIZSLA));
		dogs.add(new Dog("Rex", "Gold and Brown", Dog.Type.GERMAN_SHEPHARD));
		dogs.add(new Dog("Max", "Gold", Dog.Type.GOLDER_RETRIEVER));
		
		CSVWriter<Dog> dogWriter = new DogCSVWriter("dogs.csv", new String[] {"name", "color", "type"});
		dogWriter.write(dogs);
		
		Collection<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Adam", 26, Employee.Gender.MALE));
		employees.add(new Employee("David", 32, Employee.Gender.MALE));
		employees.add(new Employee("Krisztina", 25, Employee.Gender.FEMALE));
		CSVWriter<Employee> employeeWriter = new EmployeeCSVWriter("employees.csv", new String[] {"name", "age", "gender"});
		employeeWriter.write(employees);
	}
}
