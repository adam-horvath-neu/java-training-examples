package hu.neuron.java.web.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import hu.neuron.java.web.beans.UserSessionBean;
import hu.neuron.java.web.example.ApplicationBean;
import hu.neuron.service.UserService;
import hu.neuron.service.vo.UserVo;

@RequestScoped
@Named("loginController")
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = -508228734660295270L;

	private static final String USER = "USER";

	private static final Logger logger = LogManager.getLogger(ApplicationBean.class);

	private String userName = null;
	private String password = null;

	@Inject
	private UserService userService;

	@Inject
	UserSessionBean userSessionBean;

	public String doLogin() throws IOException, ServletException {
		try {

			UserVo user = userService.findUserByName(userName);
			logger.debug(user.getUsername());
			boolean check = BCrypt.checkpw(password, user.getPassword());
			if (check) {
				HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance()
						.getExternalContext().getRequest();

				httpServletRequest.getSession().setAttribute(USER, user);
				userSessionBean.setUser(user);
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Bad Credentials"));
			}
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Bad Credentials"));
		}
		return "index";
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}