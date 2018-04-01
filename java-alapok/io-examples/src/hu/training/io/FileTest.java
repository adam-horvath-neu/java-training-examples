package hu.training.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileTest {

	public static void main(String[] args) throws IOException {
		File directory = new File("resources\\newfolder");
		
		File file = new File(directory.getPath() + "\\testfile.txt");
		
		if (directory.exists()) {
			System.out.println("resources\\newfolder exists." );
			checkFile(file);
		} else {
			System.out.println("resources\\newfolder does not exist. Create directory.");
			if (directory.mkdir()) {
				System.out.println("Directory created.");
				checkFile(file);
			}
		}
	}
	
	private static void checkFile(final File file) throws IOException {
		BufferedReader reader = null;
		PrintWriter writer = null;
		if (file.exists()) {
			System.out.println("filein.txt exists at path: " + file.getAbsolutePath());
			reader = new BufferedReader(new FileReader(file));
			System.out.println("Content: ");
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} else {
			System.out.println("filein.txt does not exist at path: " + file.getAbsolutePath());
			if (file.createNewFile()) {
				final String message = "This file is created on Java training. \n By Adam";
				System.out.println("Writin message: " + message);
				writer = new PrintWriter(file);
				writer.write(message);
			}
		}
		if (reader != null) {
			reader.close();
		}
		if (writer != null) {
			writer.close();
		}
	}

}
