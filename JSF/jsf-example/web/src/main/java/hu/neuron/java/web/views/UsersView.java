package hu.neuron.java.web.views;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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

//	private List<UserVo> users;
	
	private LazyUserDataModel lazyUserDataModel;

	@PostConstruct
	public void init() {
//		try {
//			users = userService.getUserList();
			setLazyUserDataModel(new LazyUserDataModel(userService));
//		} catch (ServiceException e) {
//			logger.error(e.getMessage(), e);
//		}
	}

	public String getLocalName(UserVo userVo) {
		FacesContext context = FacesContext.getCurrentInstance();
		Locale locale = context.getViewRoot().getLocale();
		String languange = locale.getLanguage();

		if ("hu".equals(languange)) {
			return userVo.getLastname() + " " + userVo.getFirstname();
		} else {
			return userVo.getFirstname() + " " + userVo.getLastname();
		}
	}

	public boolean filterByLocalName(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}
		String localname = (String) value;
		return localname.toUpperCase().startsWith(filterText.toUpperCase());
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LazyUserDataModel getLazyUserDataModel() {
		return lazyUserDataModel;
	}

	public void setLazyUserDataModel(LazyUserDataModel lazyUserDataModel) {
		this.lazyUserDataModel = lazyUserDataModel;
	}

//	public List<UserVo> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserVo> users) {
//		this.users = users;
//	}

}
