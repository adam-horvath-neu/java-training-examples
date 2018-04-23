package hu.neuron.java.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.neuron.java.jdbc.PoolingDataSourceExample;
import hu.neuron.java.jdbc.dao.RegistrationDAO;
import hu.neuron.java.jdbc.dto.RegistrationDTO;

public class RegistrationDAOImpl implements RegistrationDAO {
	Connection connection;

	public RegistrationDAOImpl(Connection connection) {
		this.connection = connection;

	}

	@Override
	public Long save(RegistrationDTO dto) throws Exception {

		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "INSERT INTO REGISTRATION( last,first,age ) VALUES ( ?,?,? ) ";
			statement = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, dto.getLastName());
			statement.setString(2, dto.getFirstName());
			statement.setInt(3, dto.getAge());
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
			}

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
		}
		return rv;
	}

	@Override
	public void update(RegistrationDTO dto) throws Exception {

		PreparedStatement statement = null;
		try {
			String sql = "UPDATE REGISTRATION set last=? ,first=?, age=? where id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, dto.getLastName());
			statement.setString(2, dto.getFirstName());
			statement.setInt(3, dto.getAge());
			statement.setLong(4, dto.getId());
			int i = statement.executeUpdate();
		
		} catch (Exception e) {
			throw new Exception();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(Long id) throws Exception {
		PreparedStatement statement = null;
		try {
			String sql = "DELETE FROM REGISTRATION where id=? ";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public RegistrationDTO find(Long id) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		RegistrationDTO rv = null;
		try {
			connection = PoolingDataSourceExample.getDataSource()
					.getConnection();

			String sql = "select * from REGISTRATION where id = ?";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long rvid = resultSet.getLong("id");
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString("last");
				Integer age = resultSet.getInt("age");
				rv = new RegistrationDTO(rvid, lastName, firstName, age);
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

	@Override
	public List<RegistrationDTO> findAll() throws Exception {
		// System.out.println(Thread.currentThread().getId() + " "
		// + connection.toString());

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<RegistrationDTO> rv = new ArrayList<RegistrationDTO>();
		try {

			String sql = "select * from REGISTRATION";
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

		}
		return rv;
	}

}
