package hu.schonherz.blog.service;

import java.util.List;

import org.junit.Test;

import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserServiceImplTest {

	@Test
	public void testFindAllUser() {
		UserServiceImpl serviceImpl = new UserServiceImpl();
		List<User> list = serviceImpl.findAllUser();

		for (User user : list) {
			Login login = user.getLogin();
			System.out.println(login.getUsername() + " " + login.getPassword());
		}

	}

}
