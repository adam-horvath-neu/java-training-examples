package hu.training.writer.impl;

import java.util.ArrayList;
import java.util.Collection;

import hu.training.writer.BaseCSVWriter;
import hu.training.employee.Employee;

public class EmployeeCSVWriter extends BaseCSVWriter<Employee> {

	public EmployeeCSVWriter(String fileName, String[] header) {
		super(fileName, header);
	}

	@Override
	public Collection<Object> convertElement(Employee element) {
		Collection<Object> csvRecords = new ArrayList<>();
		csvRecords.add(element.getName());
		csvRecords.add(element.getAge());
		csvRecords.add(element.getGender());
		return csvRecords;
	}

}
