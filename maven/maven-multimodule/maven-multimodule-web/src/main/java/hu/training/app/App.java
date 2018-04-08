package hu.training.app;

import java.util.Scanner;

import hu.training.login.LoginBean;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Username:");
		String username = scanner.nextLine();
		System.out.println("Password:");
		String password = scanner.nextLine();
		if (new LoginBean().login(username, password)) {
			System.out.println("Successfull login.");
		} else {
			System.out.println("Failed to login.");
		}
		scanner.close();

	}

}
