package hu.neuron.java.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import hu.neuron.service.UserService;
import hu.neuron.service.exception.ServiceException;
import hu.neuron.service.vo.UserVo;

@Named("userNameAlreadyExistValidator")
@RequestScoped
public class UserNameAlreadyExistValidator implements Validator {

	@Inject
	UserService userService;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		UserVo userVo = null;
		try {
			userVo = userService.findUserByName((String) value);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (userVo != null) {
			throw new ValidatorException(new FacesMessage("HIBA!", "Felhasználónév már létezik!"));
		}
	}

}