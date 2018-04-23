package hu.neuron.java.jdbc;

import java.util.Date;

import junit.framework.TestCase;

public class InsertTest extends TestCase {

	public void testInsert() {
		StatementExample insertStatement = new StatementExample();
		Date date = new Date();
		for (int i = 0; i < 1000; i++) {
			insertStatement.insert(i);
		}

		System.out.println("Insert with statement: "
				+ (new Date().getTime() - date.getTime()));

		date = new Date();
		PreparedStatementExample insertPreparedStatement = new PreparedStatementExample();
		for (int i = 0; i < 1000; i++) {
			insertPreparedStatement.insert(i);
		}

		System.out.println("Insert with preparedStatement: "
				+ (new Date().getTime() - date.getTime()));

	}
}
