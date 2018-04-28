package hu.neuron.java.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import hu.neuron.service.vo.UserVo;

@SessionScoped
@Named("userSessionBean")
public class UserSessionBean implements Serializable {

	private static final long serialVersionUID = -5959611823743979912L;
	private UserVo user;
	private String theme;

	@PostConstruct
	private void init() {
		theme = "bootstrap";
	}

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
