package hu.neuron.core.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hu.neuron.core.dao.UserDao;
import hu.neuron.core.dao.util.DatasourceUtil;
import hu.neuron.core.dto.UserDto;

@Named
@ApplicationScoped
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public Long save(UserDto t) {
		Connection connection = null;
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "INSERT INTO T_USER (username, password,gender,image) VALUES ( ?, ?,?,?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getUsername());
			statement.setString(2, t.getPassword());
			statement.setString(3, t.getGender());
			statement.setBytes(4, t.getImage());

			statement.executeUpdate();

			rs = statement.getGeneratedKeys();

			if (rs.next()) {
				rv = rs.getLong(1);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return rv;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDto upadte(UserDto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto find(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDto rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "select * from T_USER where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				UserDto dto = readUserDto(resultSet);
				rv = dto;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}

		}
		return rv;
	}

	@Override
	public List<UserDto> findAll() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<UserDto> rv = new ArrayList<UserDto>();
		Connection connection = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from T_USER";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				UserDto dto = readUserDto(resultSet);
				rv.add(dto);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}

		}
		return rv;
	}

	@Override
	public UserDto findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		UserDto rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "select * from T_USER where username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				rv = readUserDto(resultSet);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}

		}
		return rv;
	}

	private UserDto readUserDto(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		String username = resultSet.getString("username");
		String password = resultSet.getString("password");
		String gender = resultSet.getString("gender");
		byte[] image = resultSet.getBytes("image");
		UserDto dto = new UserDto(id, username, password, gender, image);
		return dto;
	}

}
