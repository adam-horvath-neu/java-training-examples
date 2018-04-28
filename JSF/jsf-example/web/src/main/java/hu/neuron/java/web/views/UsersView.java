package hu.neuron.java.web.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hu.neuron.service.UserService;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.UserVo;

@ViewScoped
@Named("usersView")
public class UsersView implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(UsersView.class);

	@Inject
	private UserService userService;

	private List<UserVo> users;

	@PostConstruct
	public void init() {
		try {
			users = userService.getUserList();
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<UserVo> getUsers() {
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}

}
