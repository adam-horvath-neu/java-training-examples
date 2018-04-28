package hu.neuron.java.web.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(SessionBean.class);

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;

	@PostConstruct
	public void init() {
		logger.info("SessionBean create");
	}

	private Long count = 0l;

	public void increase() {
		count += 1;
		getApplicationBean().increase();
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

}
