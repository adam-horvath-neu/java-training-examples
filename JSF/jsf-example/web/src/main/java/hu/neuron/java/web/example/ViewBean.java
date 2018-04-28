package hu.neuron.java.web.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ViewScoped
@ManagedBean(name = "viewBean")
public class ViewBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(ViewBean.class);

	@ManagedProperty(value = "#{sessionBean}")
	private SessionBean sessionBean;

	@PostConstruct
	public void init() {
		logger.info("ViewBean create");
	}

	private Long result = 0l;

	public void add(Long value) {
		result += value;
		getSessionBean().increase();
	}

	public void minus(Long value) {
		result -= value;
		getSessionBean().increase();
	}

	public Long getResult() {
		return result;
	}

	public void setResult(Long result) {
		this.result = result;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
