package hu.neuron.java.web.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(name = "requestBean")
@RequestScoped
public class RequestBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(RequestBean.class);

	@ManagedProperty(value = "#{viewBean}")
	private ViewBean viewBean;

	@PostConstruct
	public void init() {
		logger.info("RequestBean create");
		result = 0l;
	}

	private Long value = 0l;

	private Long result;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public void add() {
		getViewBean().add(value);
		result += value;
	}

	public void minus() {
		getViewBean().minus(value);
		result -= value;
	}

	public ViewBean getViewBean() {
		return viewBean;
	}

	public void setViewBean(ViewBean viewBean) {
		this.viewBean = viewBean;
	}

	public Long getResult() {
		return result;
	}

	public void setResult(Long result) {
		this.result = result;
	}
}
