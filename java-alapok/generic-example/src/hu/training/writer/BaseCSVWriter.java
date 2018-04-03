package hu.training.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public abstract class BaseCSVWriter<T> implements CSVWriter<T> {

	protected String fileName;
	private final CSVFormat csvFileFormat;

	public BaseCSVWriter(String fileName, String[] header) {
		super();
		this.fileName = fileName;
		this.csvFileFormat = CSVFormat.DEFAULT.withHeader(header).withRecordSeparator("\n");
	}

	@Override
	public void write(Collection<T> elements) throws IOException {
		File file = new File(this.fileName + ".csv");
		CSVPrinter csvPrinter = null;
		
		try {
			csvPrinter = new CSVPrinter(new FileWriter(file), this.csvFileFormat);

			for (T element : elements) {
				csvPrinter.printRecord(this.convertElement(element));
			}

			csvPrinter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (csvPrinter != null) {
				csvPrinter.close();
			}
		}
	}

	public abstract Collection<Object> convertElement(T element);

}
