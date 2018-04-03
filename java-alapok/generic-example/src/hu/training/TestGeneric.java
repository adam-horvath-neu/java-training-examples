package hu.training;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestGeneric {
	
	public static class Stack<T extends Person & Serializable> {
		private List<T> values;

		public Stack() {
			super();
			this.values = new LinkedList<>();
		}
		
		public void push(T t) {
			this.values.add(t);
		}
		
		public T pop() {
			LinkedList<T> list = (LinkedList<T>) this.values;
			T last = list.getLast();
			list.removeLast();
			return last;
		}

		public Collection<T> getValues() {
			return values;
		}
		
	}
	
	public static class Person implements Serializable {

		private static final long serialVersionUID = 1L;
		
		protected String name;

		public Person(String name) {
			super();
			this.name = name;
		}
		
		public void shoutName() {
			System.out.println("I'm a person. My name is " + this.name);
		}

		@Override
		public String toString() {
			return "Person [name=" + name + "]";
		}
	}
	
	public static class Employee extends Person {
		
		private static final long serialVersionUID = 1L;

		public Employee(String name) {
			super(name);
		}
		
		public void shoutName() {
			System.out.println("I'm an employee. My name is " + this.name);
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + "]";
		}
	}

	public static void main(String[] args) {
		// Figyeld az osztalydeklaraciot
		Stack<Person> stack = new Stack<>();
		stack.push(new Person("Béla"));
		stack.push(new Employee("József"));
		stack.push(new Person("Árpád"));
		stack.push(new Employee("Géza"));
		System.out.println(stack.values);
		Person pop = stack.pop();
		System.out.println("pop: " + pop);
		System.out.println(stack.values);
		
		System.out.println("\n--Any list---");
		List<String> names = Arrays.asList(new String[] {"Béla", "József", "Árpád", "Géza"});
		printAnyList(names);
		
		System.out.println("\n--Shout people---");
		shoutPeople(stack.values);
		
		Person kinga = new Person("Kinga");
		Person eva = new Person("Éva");
		Person dora = new Employee("Dóra");
		
		System.out.println("\n--Generic method return value--");
		System.out.println(getName(eva));
		System.out.println(getName(kinga));
		System.out.println(getName(dora));
		
		System.out.println("\n--Generic method execute method--");
		shoutName(kinga);
		shoutName(eva);
		shoutName(dora);
		
	}
	
	private static void printAnyList(List<?> list) {
		list.forEach(System.out::println);
	}
	
	private static void shoutPeople(List<? extends Person> list) {
		list.forEach(person -> person.shoutName());
	}
	
	private static <T extends Person> String getName(T t) {
		return t.name;
	}
	
	private static <T extends Person> void shoutName(T t) {
		t.shoutName();
	}

}
