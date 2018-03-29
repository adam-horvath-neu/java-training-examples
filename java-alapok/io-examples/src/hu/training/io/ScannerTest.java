package hu.training.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream("resources\\scanner.txt"));
			while (scanner.hasNextInt()) {
				System.out.println(scanner.nextInt());
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
