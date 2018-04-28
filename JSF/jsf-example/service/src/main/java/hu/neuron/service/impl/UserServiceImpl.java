package hu.neuron.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import hu.neuron.core.dao.UserDao;
import hu.neuron.core.dao.impl.UserDaoImpl;
import hu.neuron.service.UserService;
import hu.neuron.service.converter.UserConverter;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.UserVo;

@Named
@ApplicationScoped
public class UserServiceImpl implements UserService {
	@Inject
	private UserDao userDao;

	@Override
	public UserVo registration(UserVo vo) {

		String encodedPassword = BCrypt.hashpw(vo.getPassword(), BCrypt.gensalt());
		vo.setPassword(encodedPassword);

		Long id = getUserDao().save(UserConverter.toUserDto(vo));

		return UserConverter.toUserVo(getUserDao().find(id));
	}

	@Override
	public UserVo findUserById(Long id) {

		return UserConverter.toUserVo(getUserDao().find(id));
	}

	@Override
	public UserVo findUserByName(String userName) throws ServiceException {

		return UserConverter.toUserVo(getUserDao().findByName(userName));
	}

	@Override
	public void saveUser(UserVo userVo) {
		getUserDao().upadte(UserConverter.toUserDto(userVo));
	}

	@Override
	public List<UserVo> getUserList() throws ServiceException {
		return UserConverter.toUserVo(getUserDao().findAll());
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
