package hu.sconherz.blog.web.login;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public LoginForm() {

	}

	public LoginForm(HttpServletRequest request) {
		username = request.getParameter("username");
		password = request.getParameter("password");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
