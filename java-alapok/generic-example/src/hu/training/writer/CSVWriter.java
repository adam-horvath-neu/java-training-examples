package hu.training.writer;

import java.io.IOException;
import java.util.Collection;

public interface CSVWriter<T> {

	void write(Collection<T> t) throws IOException;
}
