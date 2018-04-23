package hu.neuron.java.jdbc;

import hu.neuron.java.jdbc.dto.RegistrationDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatementExample {

	public void insert(int i) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.createStatement();

			String sql = "INSERT INTO REGISTRATION( last,first ) VALUES ( 'Rob"
					+ i + "','Rob" + i + "' ) ";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public List<RegistrationDTO> select() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<RegistrationDTO> rv = new ArrayList<RegistrationDTO>();
		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.createStatement();

			String sql = "select * from REGISTRATION where last like('%b%')";
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString("last");
				Integer age = resultSet.getInt("age");
				rv.add(new RegistrationDTO(id, lastName, firstName, age));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rv;
	}

	public void insertWithPool(int i) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = PoolingDataSourceExample.getDataSource()
					.getConnection();

			statement = connection.createStatement();

			String sql = "INSERT INTO REGISTRATION( last,first ) VALUES ( 'Rob"
					+ i + "','Rob" + i + "' ) ";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void insertBatchWithPool(int i) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = PoolingDataSourceExample.getDataSource()
					.getConnection();

			statement = connection.createStatement();

			for (int j = 0; j < i; j++) {

				String sql = "INSERT INTO REGISTRATION( last,first ) VALUES ( 'Rob"
						+ j + "','Rob" + j + "' ) ";
				statement.addBatch(sql);
			}

			statement.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public List<RegistrationDTO> selectWithPool() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<RegistrationDTO> rv = new ArrayList<RegistrationDTO>();
		try {
			connection = PoolingDataSourceExample.getDataSource()
					.getConnection();

			statement = connection.createStatement();

			String sql = "select * from REGISTRATION where last like('%b%')";
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString("last");
				Integer age = resultSet.getInt("age");
				rv.add(new RegistrationDTO(id, lastName, firstName, age));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rv;
	}
}
