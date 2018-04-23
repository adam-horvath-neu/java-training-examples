package hu.neuron.java.jdbc;

import hu.neuron.java.jdbc.dto.RegistrationDTO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

public class SelectTestPreparedStatement extends TestCase {

	public void testSelect() throws Exception {

		final PreparedStatementExample preparedStatementExample = new PreparedStatementExample();

		Date date = new Date();
		List<RegistrationDTO> list;

		for (int i = 0; i < 10; i++) {
			date = new Date();
			list = preparedStatementExample.select();

			System.out.println("Select " + list.size()
					+ " with preparedStatement: "
					+ (new Date().getTime() - date.getTime()));
		}

		for (int i = 0; i < 10; i++) {
			date = new Date();
			list = preparedStatementExample.selectWithPool();

			System.out.println("Select " + list.size()
					+ " with preparedStatement and pool: "
					+ (new Date().getTime() - date.getTime()));
		}
		
		try {
			PoolingDataSourceExample.shutdownDataSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
