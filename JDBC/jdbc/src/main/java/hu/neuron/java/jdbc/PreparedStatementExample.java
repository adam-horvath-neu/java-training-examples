package hu.neuron.java.jdbc;

import hu.neuron.java.jdbc.dto.RegistrationDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementExample {

	public void insert(int i) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionFactory.getConnection();

			String sql = "INSERT INTO REGISTRATION( last,first ) VALUES ( ?,? ) ";
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, "Bob" + i);
			statement.setString(2, "Bob" + i);
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				// System.out.println(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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
	}

	public List<RegistrationDTO> select() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<RegistrationDTO> rv = new ArrayList<RegistrationDTO>();
		try {
			connection = ConnectionFactory.getConnection();

			String sql = "select * from REGISTRATION where last like('%b%')";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

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
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = PoolingDataSourceExample.getDataSource()
					.getConnection();
			String sql = "INSERT INTO REGISTRATION( last,first ) VALUES ( ?,? ) ";
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, "Bob" + i);
			statement.setString(2, "Bob" + i);
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				// System.out.println(rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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
	}

	public void insertBatchWithPool(int i) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = PoolingDataSourceExample.getDataSource()
					.getConnection();
			String sql = "INSERT INTO REGISTRATION( last,first ) VALUES ( ?,? ) ";
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			for (int j = 0; j < i; j++) {

				statement.setString(1, "Bob" + j);
				statement.setString(2, "Bob" + j);
				statement.addBatch();
			}

			statement.executeBatch();
			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				// System.out.println("id: "+rs.getLong(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
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
	}

	public List<RegistrationDTO> selectWithPool() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<RegistrationDTO> rv = new ArrayList<RegistrationDTO>();
		try {
			connection = PoolingDataSourceExample.getDataSource()
					.getConnection();

			String sql = "select * from REGISTRATION where last like('%b%')";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

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
