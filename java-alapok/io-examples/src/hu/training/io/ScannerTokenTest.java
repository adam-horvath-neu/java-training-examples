package hu.training.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScannerTokenTest {
	public static void main(String[] args) throws IOException {
		Scanner s = null;
		double sum = 0.0;

		try {
			s = new Scanner(new BufferedReader(new FileReader("resources\\scanner.txt")));
			s.useLocale(Locale.UK);

			while (s.hasNext()) {
				if (s.hasNextDouble()) {
					double nextDouble = s.nextDouble();
					System.out.println("Next double: " + nextDouble);
					sum += s.nextDouble();
				} else {
					String nextValue = s.next();
					System.out.println("Next value: " + nextValue);
				}
			}
		} finally {
			s.close();
		}

		System.out.println(sum);
	}
}
