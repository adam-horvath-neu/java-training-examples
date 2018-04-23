package hu.neuron.java.jdbc;

import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.TestCase;

public class InsertTestWithPoolParalel extends TestCase {

	public void testInsert() {
		final StatementExample insertStatement = new StatementExample();
		final PreparedStatementExample insertPreparedStatement = new PreparedStatementExample();

		Date date = new Date();
		ExecutorService executor = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 1000; i++) {
			final int z = i;
			Runnable worker = new Thread() {
				@Override
				public void run() {
					insertStatement.insertWithPool(z);
//					PoolingDataSourceExample.prinStats();
				}
			};
			executor.execute(worker);

		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Insert with statement and pool: "
				+ (new Date().getTime() - date.getTime()));

		date = new Date();
		executor = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 1000; i++) {

			final int z = i;
			Runnable worker = new Thread() {
				@Override
				public void run() {
					insertPreparedStatement.insertWithPool(z);
//					PoolingDataSourceExample.prinStats();
				}
			};
			executor.execute(worker);

		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Insert with preparedstatement and pool: "
				+ (new Date().getTime() - date.getTime()));

		try {
			PoolingDataSourceExample.shutdownDataSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
