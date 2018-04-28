package hu.schonherz.blog.service;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.postgresql.ds.PGSimpleDataSource;

import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserServiceImplTest {
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
	public void testFindAllUser() {
		UserServiceImpl serviceImpl = new UserServiceImpl();
		List<User> list = serviceImpl.findAllUser();

		for (User user : list) {
			Login login = user.getLogin();
			System.out.println(login.getUsername() + " " + login.getPassword());
		}

	}

	@Test
	public void testFindUserByName() {
		UserServiceImpl serviceImpl = new UserServiceImpl();
		User user = null;
		try {
			user = serviceImpl.findUserByName("aaa");
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(user);

	}

}
