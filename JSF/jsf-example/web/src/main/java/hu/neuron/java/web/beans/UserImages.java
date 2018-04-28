package hu.neuron.java.web.beans;

import java.io.ByteArrayInputStream;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import hu.neuron.service.UserService;
import hu.neuron.service.vo.UserVo;

@ApplicationScoped
@Named("userImages")
public class UserImages {

	@Inject
	private UserService userService;

	public StreamedContent getImage() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			String userId = context.getExternalContext().getRequestParameterMap().get("userId");
			UserVo userVO = getUserService().findUserById((Long.valueOf(userId)));
			byte[] image = userVO.getImage();
			if (image != null) {
				return new DefaultStreamedContent(new ByteArrayInputStream(image));
			} else {
				return new DefaultStreamedContent();
			}
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}