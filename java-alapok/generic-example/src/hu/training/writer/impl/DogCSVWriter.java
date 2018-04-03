package hu.training.writer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.training.dog.Dog;
import hu.training.writer.BaseCSVWriter;

public class DogCSVWriter extends BaseCSVWriter<Dog> {

	public DogCSVWriter(String fileName, String[] header) {
		super(fileName, header);
	}

	@Override
	public Collection<Object> convertElement(Dog element) {
		List<Object> csvRecords = new ArrayList<>();
		csvRecords.add(element.getName());
		csvRecords.add(element.getColor());
		csvRecords.add(element.getType());
		return csvRecords;
	}

}
