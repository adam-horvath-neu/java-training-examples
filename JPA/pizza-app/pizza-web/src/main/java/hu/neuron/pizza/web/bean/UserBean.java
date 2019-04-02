package hu.neuron.pizza.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import hu.neuron.pizza.service.user.UserServiceLocal;
import hu.neuron.pizza.service.vo.user.UserVo;

import java.io.Serializable;

@Named("userBean")
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserServiceLocal serviceLocal;

	private List<UserVo> users;

	private UserVo user;

	@PostConstruct
	public void init() {
		users = getServiceLocal().getAllUsers();
		user = new UserVo();
	}

	public void addUser() {
		serviceLocal.addUser(user);
	}

	public UserServiceLocal getServiceLocal() {
		return serviceLocal;
	}

	public void setServiceLocal(UserServiceLocal serviceLocal) {
		this.serviceLocal = serviceLocal;
	}

	public List<UserVo> getUsers() {
		users = getServiceLocal().getAllUsers();
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

}
