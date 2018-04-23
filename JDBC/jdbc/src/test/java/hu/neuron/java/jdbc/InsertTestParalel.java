package hu.neuron.java.jdbc;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.TestCase;

public class InsertTestParalel extends TestCase {

	public void testInsert() {
		final StatementExample insertStatement = new StatementExample();
		final PreparedStatementExample insertPreparedStatement = new PreparedStatementExample();
		ExecutorService executor = Executors.newFixedThreadPool(50);
		Date date = new Date();
		for (int i = 0; i < 1000; i++) {
			final int z = i;
			Runnable worker = new Thread() {
				@Override
				public void run() {
					insertStatement.insert(z);
				}
			};
			executor.execute(worker);

		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Insert with statement: "
				+ (new Date().getTime() - date.getTime()));

		date = new Date();
		 executor = Executors.newFixedThreadPool(50);
		for (int i = 0; i < 1000; i++) {
			final int z = i;
			Runnable worker = new Thread() {
				@Override
				public void run() {
					insertPreparedStatement.insert(z);
				}
			};
			executor.execute(worker);

		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		System.out.println("Insert with preparedStatement: "
				+ (new Date().getTime() - date.getTime()));

	}
}
