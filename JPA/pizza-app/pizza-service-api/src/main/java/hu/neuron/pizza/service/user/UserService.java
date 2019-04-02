package hu.neuron.pizza.service.user;

import java.util.List;

import hu.neuron.pizza.service.vo.user.RoleVo;
import hu.neuron.pizza.service.vo.user.UserVo;

public interface UserService {

	Long addUser(UserVo vo);

	void addRoleToUser(UserVo user, RoleVo role);

	void removeRoleFromUser(UserVo user, RoleVo role);

	void removeUser(Long id);

	List<UserVo> getAllUsers();

}
