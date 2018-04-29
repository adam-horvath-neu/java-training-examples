package hu.neuron.service.test;

import org.junit.Test;

import hu.neuron.service.UserService;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;

public class UserServiceTest {
	

	@Test
	public void testRegistration() {
		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		vo.setPassword("pass");
		vo.setUsername("user");
		try {
			service.registration(vo);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
