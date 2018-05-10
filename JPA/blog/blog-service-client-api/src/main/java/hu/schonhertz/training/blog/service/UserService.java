package hu.schonhertz.training.blog.service;

import hu.schonhertz.training.blog.vo.UserVo;

public interface UserService {

	public UserVo findUserByName(String name) throws Exception;

	public void registrationUser(UserVo userVO) throws Exception;

	public UserVo setUpRoles(UserVo vo) throws Exception;
}
