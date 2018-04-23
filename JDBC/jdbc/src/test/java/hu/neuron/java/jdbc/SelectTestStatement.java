package hu.neuron.java.jdbc;

import hu.neuron.java.jdbc.dto.RegistrationDTO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

public class SelectTestStatement extends TestCase {

	public void testSelect() throws Exception {
		final StatementExample statementExample = new StatementExample();

		Date date;
		List<RegistrationDTO> list;

		for (int i = 0; i < 10; i++) {
			date = new Date();
			list = statementExample.select();

			System.out.println("Select " + list.size() + " with statement: "
					+ (new Date().getTime() - date.getTime()));
		}

		for (int i = 0; i < 10; i++) {
			date = new Date();
			list = statementExample.selectWithPool();

			System.out.println("Select " + list.size()
					+ " with statement and pool: "
					+ (new Date().getTime() - date.getTime()));
		}

		try {
			PoolingDataSourceExample.shutdownDataSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
