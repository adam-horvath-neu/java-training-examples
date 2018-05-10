package hu.schonherz.jee.transaction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class TestDao {
	private static Log logger = LogFactory.getLog(TestDao.class);
	@Resource(mappedName = "java:/PostgresXADS")
	DataSource dataSource;

	public void createTable() {
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement("DROP TABLE IF EXISTS TEST ");
			ps.execute();

			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
			}

			ps = con.prepareStatement("CREATE TABLE TEST (" + "test varchar(255)" + ")");
			ps.execute();

			logger.info("CREATE TABLE TEST");
		} catch (SQLException sql) {
			throw new EJBException(sql);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}

	public void insert(String text) {
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement("INSERT INTO TEST (TEST) VALUES (?)");
			ps.setString(1, text);
			ps.execute();

		} catch (SQLException sql) {
			throw new EJBException(sql);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void insertNewTransaction(String text) {
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = dataSource.getConnection();

			ps = con.prepareStatement("INSERT INTO TEST (TEST) VALUES (?)");
			ps.setString(1, text);
			ps.execute();

		} catch (SQLException sql) {
			throw new EJBException(sql);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
	}
}
