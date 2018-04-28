package hu.neuron.service;

import java.util.List;

import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.UserVo;

public interface UserService {

	UserVo registration(UserVo vo) throws ServiceException;

	UserVo findUserById(Long id) throws ServiceException;

	UserVo findUserByName(String userName) throws ServiceException;

	void saveUser(hu.neuron.service.vo.UserVo userVo) throws ServiceException;

	List<UserVo> getUserList() throws ServiceException;

}
