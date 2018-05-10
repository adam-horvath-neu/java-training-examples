package hu.schonherz.blog.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

public class UserDao implements GenericDao<UserDto> {

	@Override
	public Long save(UserDto t) {

		DataSource ds = DatasourceUtil.getDatasource();

		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {

			String sql = "INSERT INTO registration (firstname, lastname, age, username, url, password, email, phone) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = ds.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getLastname());
			statement.setString(2, t.getFirstname());
			statement.setLong(3, t.getAge());
			statement.setString(4, t.getUsername());
			statement.setString(5, t.getUrl());
			statement.setString(6, t.getPassword());
			statement.setString(7, t.getEmail());
			statement.setString(8, t.getPhone());
			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
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
		}
		return rv;
	}

	@Override
	public UserDto update(UserDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDto findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDto rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "select * from REGISTRATION where username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				Long age = resultSet.getLong("age");
				String username = resultSet.getString("username");
				String url = resultSet.getString("url");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				rv = new UserDto(id, username, firstname, lastname, url, password, email, phone, age);
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
