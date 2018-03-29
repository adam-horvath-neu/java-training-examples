package hu.training.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamTest {

	private static class Employee implements Serializable {
		private String name;
		private int age;

		public Employee(String name, int age) {
			super();
			this.name = name;
			this.age = age;
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
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;
		try {
			Employee employee = new Employee("Horváth Ádám", 26);
			outputStream = new ObjectOutputStream(new FileOutputStream("resources\\object.txt"));
			outputStream.writeObject(employee);
			inputStream = new ObjectInputStream(new FileInputStream("resources\\object.txt"));
			
			Employee readObject = (Employee) inputStream.readObject();
			System.out.println(readObject);
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

}
