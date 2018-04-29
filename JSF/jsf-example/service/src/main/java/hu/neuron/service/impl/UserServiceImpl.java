package hu.neuron.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import hu.neuron.core.dao.RoleDao;
import hu.neuron.core.dao.UserDao;
import hu.neuron.core.dto.RoleDto;
import hu.neuron.service.UserService;
import hu.neuron.service.converter.UserConverter;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.UserVo;

@Named
@ApplicationScoped
public class UserServiceImpl implements UserService {

	private static final String USER_ROLE = "user";

	@Inject
	private UserDao userDao;

	@Inject
	private RoleDao roleDao;

	@Inject
	private UserConverter userConverter;

	@Override
	public UserVo registration(UserVo vo) {

		String encodedPassword = BCrypt.hashpw(vo.getPassword(), BCrypt.gensalt());
		vo.setPassword(encodedPassword);

		Long userId = userDao.save(userConverter.toUserDto(vo));
		RoleDto roleDto = roleDao.findByName(USER_ROLE);
		roleDao.addRoleToUser(roleDto.getId(), userId);
		return userConverter.toUserVo(userDao.find(userId));
	}

	@Override
	public UserVo findUserById(Long id) {

		return userConverter.toUserVo(userDao.find(id));
	}

	@Override
	public UserVo findUserByName(String userName) throws ServiceException {

		return userConverter.toUserVo(userDao.findByName(userName));
	}

	@Override
	public void saveUser(UserVo userVo) {
		userDao.upadte(userConverter.toUserDto(userVo));
	}

	@Override
	public List<UserVo> getUserList() throws ServiceException {
		return userConverter.toUserVo(userDao.findAll());
	}

}
