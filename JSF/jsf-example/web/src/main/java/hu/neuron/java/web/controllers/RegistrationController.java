package hu.neuron.java.web.controllers;

import java.awt.geom.Area;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

import hu.neuron.service.UserService;
import hu.neuron.service.vo.Gender;
import hu.neuron.service.vo.UserVo;

@ViewScoped
@Named("registrationController")
public class RegistrationController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(RegistrationController.class);

	private UserVo userVo;

	private String password2 = "";

	@PostConstruct
	public void init() {
		userVo = new UserVo();

	}

	@Inject
	private UserService userService;

	public String addUser() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (!userVo.getPassword().equals(getPassword2())) {

				context.addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "global.error", "password_not_match"));
				return null;
			} else if (getUserService().findUserByName(userVo.getUsername()) != null) {
				addErrorMessage("password_not_match");
				return null;
			}

			getUserService().registration(userVo);

			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registration sucessful you can log in now"));

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
			return "/public/registration.xhtml?faces-redirect=true";
		}

		return "/public/login.xhtml?faces-redirect=true";
	}

	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
	}

	private void addErrorMessage(String string) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "global.error",
				ResourceBundle.getBundle("hu.neuron.java.Messages").getString(string)));
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

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

	public List<Gender> getGenders() {
		return Arrays.asList(Gender.values());
	}

}
