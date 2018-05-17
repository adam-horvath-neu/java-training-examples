package hu.neuron.java.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import generated.UserWebServiceVo;
import hu.neuron.java.rest.client.UserApi;
import hu.neuron.java.rest.client.UserApi.Users.Save;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UserWebServiceVo> users;

	private UserWebServiceVo user;

	@PostConstruct
	public void init() {
		user = new UserWebServiceVo();
		user.setId(1l);
		user.setImage(new byte[1]);
		user.setPassword("ddfds");
	}

	public void addUser() {

		Save save = UserApi.users().save();

		save.putJsonAsUserWebServiceVo(user);
	}

	public List<UserWebServiceVo> getUsers() {
		users = UserApi.users().list().getAsUserWebServiceVoList().getUserWebServiceVos();
		return users;
	}

	public void setUsers(List<UserWebServiceVo> users) {
		this.users = users;
	}

	public UserWebServiceVo getUser() {
		return user;
	}

	public void setUser(UserWebServiceVo user) {
		this.user = user;
	}

}
