package hu.neuron.java.web.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.neuron.service.UserService;
import hu.neuron.service.vo.UserVo;

@ViewScoped
@Named("registrationController")
public class RegistrationController implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName = "";

	private String password = "";

	private String password2 = "";

	@Inject
	private UserService userService;

	public String addUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (!password.equals(getPassword2())) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Password not match"));
				return null;
			} else if (getUserService().findUserByName(userName) != null) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
						"Sorry we already have a user with this name"));
				return null;
			}

			UserVo UserVo = new UserVo();

			UserVo.setPassword(password);
			UserVo.setUsername(userName);

			getUserService().registration(UserVo);

			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registration sucessful you can log in now"));

		} catch (Exception e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
			return "/public/registration.xhtml?faces-redirect=true";
		}

		return "/public/login.xhtml?faces-redirect=true";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
