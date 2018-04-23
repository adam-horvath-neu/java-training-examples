package hu.neuron.java.jdbc;

import java.sql.SQLException;
import java.util.Date;

import junit.framework.TestCase;

public class InsertTestWithPool extends TestCase {

	public void testInsert() {
		StatementExample insertStatement = new StatementExample();
		PreparedStatementExample insertPreparedStatement = new PreparedStatementExample();

		Date date = new Date();

		date = new Date();
		for (int i = 0; i < 1000; i++) {
			insertStatement.insertWithPool(i);
			// PoolingDataSourceExample.prinStats();
		}

		System.out.println("Insert with statement and pool: "
				+ (new Date().getTime() - date.getTime()));

		date = new Date();

		insertStatement.insertBatchWithPool(1000);

		System.out.println("Insert with statement and pool batch: "
				+ (new Date().getTime() - date.getTime()));

		date = new Date();
		for (int i = 0; i < 1000; i++) {
			insertPreparedStatement.insertWithPool(i);
			// PoolingDataSourceExample.prinStats();
		}

		System.out.println("Insert with preparedstatement and pool: "
				+ (new Date().getTime() - date.getTime()));

		date = new Date();
		insertPreparedStatement.insertBatchWithPool(1000);

		System.out.println("Insert with preparedstatement and pool batch: "
				+ (new Date().getTime() - date.getTime()));

		try {
			PoolingDataSourceExample.shutdownDataSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
