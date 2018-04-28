package hu.neuron.java.jdbc;

import java.sql.SQLException;
import java.util.Date;

import junit.framework.TestCase;

public class InsertTest extends TestCase {

	public void testInsert() {
		

		Date date = new Date();
		PreparedStatementExample insertPreparedStatement = new PreparedStatementExample();
		try {
		for (int i = 0; i < 1000; i++) {
			insertPreparedStatement.insert(i);
			insertPreparedStatement.insertWithPool(i);
		}
		}catch (Exception e) {
			try {
				 insertPreparedStatement.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		try {
			insertPreparedStatement.getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Insert with preparedStatement: "
				+ (new Date().getTime() - date.getTime()));

	}
}
