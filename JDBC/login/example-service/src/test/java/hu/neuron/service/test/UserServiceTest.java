package hu.neuron.service.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.postgresql.ds.PGSimpleDataSource;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;

public class UserServiceTest {
	@BeforeClass
	public static void setUp() throws Exception {
		try {
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");

			PGSimpleDataSource ds = new PGSimpleDataSource();
			ds.setServerName("localhost");
			ds.setPortNumber(5432);
			ds.setDatabaseName("training");
			ds.setUser("postgres");
			ds.setPassword("admin");
			
			InitialContext ic = new InitialContext();
			ic.createSubcontext("java:");
			ic.createSubcontext("java:/comp");
			ic.createSubcontext("java:/comp/env");
			ic.createSubcontext("java:/comp/env/jdbc");

			DataSource ds2 = (DataSource) ds;
			ic.bind("java:/comp/env/jdbc/TestDB", ds2);

		} catch (NamingException ex) {
		}

	}

	@Test
	public void testRegistration() {
		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		vo.setPassword("pass");
		vo.setUsername("user");
		service.registration(vo);
	}

}
