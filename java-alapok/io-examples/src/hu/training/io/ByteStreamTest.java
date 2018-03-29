package hu.training.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest {

	public static void main(String[] args) throws IOException {
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream("resources\\bytein.txt");
			outputStream = new FileOutputStream("resources\\byteout.txt");
			int byteIn;
			while ((byteIn = inputStream.read()) != -1) {
				outputStream.write(byteIn);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
