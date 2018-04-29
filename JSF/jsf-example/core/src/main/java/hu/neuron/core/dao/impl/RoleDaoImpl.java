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

import hu.neuron.core.dao.RoleDao;
import hu.neuron.core.dao.util.DatasourceUtil;
import hu.neuron.core.dto.RoleDto;

@Named
@ApplicationScoped
public class RoleDaoImpl implements RoleDao {
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

	@Override
	public Long save(RoleDto t) {
		Connection connection = null;
		Long rv = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "INSERT INTO ROLE_TABLE ( name) VALUES ( ?)";

			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, t.getName());

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
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "DELETE FROM ROLE_TABLE WHERE id=?";

			statement = connection.prepareStatement(sql);

			statement.setLong(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
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

	}

	@Override
	public void upadte(RoleDto t) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "UPDATE ROLE_TABLE SET  name=? WHERE (id=?)";

			statement = connection.prepareStatement(sql);

			statement.setString(1, t.getName());

			statement.setLong(2, t.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
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
	}

	@Override
	public RoleDto find(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		RoleDto rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "select * from ROLE_TABLE where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RoleDto dto = readRoleDto(resultSet);
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
	public List<RoleDto> findAll() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<RoleDto> rv = new ArrayList<RoleDto>();
		Connection connection = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select * from ROLE_TABLE";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RoleDto dto = readRoleDto(resultSet);
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
	public List<RoleDto> findRolesByUser(Long id) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<RoleDto> rv = new ArrayList<RoleDto>();
		Connection connection = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();
			String sql = "select r.* from ROLE_TABLE r , USER_ROLE_SW  sw where sw.role_id = r.id and sw.user_id =?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RoleDto dto = readRoleDto(resultSet);
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
	public void addRoleToUser(Long roleId, Long userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "INSERT INTO USER_ROLE_SW (user_id, role_id) VALUES (?, ?);";

			statement = connection.prepareStatement(sql);

			statement.setLong(1, userId);

			statement.setLong(2, roleId);

			statement.executeUpdate();

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
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

	}

	@Override
	public void removeRoleFromUser(Long roleId, Long userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "DELETE FROM USER_ROLE_SW WHERE usre_id=? and role_id=?";

			statement = connection.prepareStatement(sql);

			statement.setLong(1, userId);

			statement.setLong(2, roleId);

			statement.executeUpdate();

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
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

	}

	@Override
	public RoleDto findByName(String name) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		RoleDto rv = null;
		try {
			connection = DatasourceUtil.getDatasource().getConnection();

			String sql = "select * from ROLE_TABLE where name = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				RoleDto dto = readRoleDto(resultSet);
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

	private RoleDto readRoleDto(ResultSet resultSet) throws SQLException {

		Long id = resultSet.getLong("id");
		String name = resultSet.getString("name");

		return new RoleDto(id, name);
	}

}
