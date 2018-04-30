package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import hu.neuron.service.vo.UserVo;

@SessionScoped
@Named("userSessionBean")
public class UserSessionBean implements Serializable {

	private static final long serialVersionUID = -5959611823743979912L;
	private UserVo user;
	private String theme;
	private List<String> langs;
	private String selectedLang;

	@Inject
	private ThemeService service;
	private List<Theme> themes;

	@PostConstruct
	private void init() {
		theme = "bootstrap";
		langs = new ArrayList<>();
		langs.add("hu");
		langs.add("en");
		themes = service.getThemes();
	}

	public void selectLang() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(selectedLang));
	}

	public Boolean hasRole(String role) {
		return user.getRoles().stream().anyMatch(x -> x.getName().equals(role));
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

	public List<String> getLangs() {
		return langs;
	}

	public void setLangs(List<String> langs) {
		this.langs = langs;
	}

	public String getSelectedLang() {
		return selectedLang;
	}

	public void setSelectedLang(String selectedLang) {
		this.selectedLang = selectedLang;
	}

	public ThemeService getService() {
		return service;
	}

	public void setService(ThemeService service) {
		this.service = service;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}
}
