package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.mindrot.jbcrypt.BCrypt;

import hu.schonhertz.training.blog.dao.client.RoleDao;
import hu.schonhertz.training.blog.dao.client.UserDao;
import hu.schonhertz.training.blog.dto.client.RoleDto;
import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.service.mapper.RoleMapper;
import hu.schonhertz.training.blog.service.mapper.UserMapper;
import hu.schonhertz.training.blog.vo.UserVo;

@Stateless
@Local(UserService.class)
public class UserServiceImpl implements UserService {
	@EJB
	UserDao userDao;

	@EJB
	RoleDao roleDao;

	public UserServiceImpl() {
	}

	@Override
	public UserVo findUserByName(String name) throws Exception {
		UserVo vo = UserMapper.toVo(userDao.findUserByName(name));
		return vo;

	}

	@Override
	public UserVo setUpRoles(UserVo vo) throws Exception {
		List<RoleDto> roles;
		try {
			roles = roleDao.findRolesByUserId(vo.getId());
			vo.setRoles(RoleMapper.toVo(roles));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;

	}

	@Override
	public void registrationUser(UserVo userVo) throws Exception {

		String encodedPassword = BCrypt.hashpw(userVo.getPassword(), BCrypt.gensalt());
		userVo.setPassword(encodedPassword);
		
		Long userId = userDao.save(UserMapper.toDto(userVo));
		RoleDto userRole = roleDao.findRoleByName("ROLE_USER");
		roleDao.addRoleToUser(userRole.getId(), userId);
	}

}
