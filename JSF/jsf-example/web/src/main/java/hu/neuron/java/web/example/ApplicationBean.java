package hu.neuron.java.web.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(name = "applicationBean",eager=true)
@ApplicationScoped
public class ApplicationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(ApplicationBean.class);

	@PostConstruct
	public void init() {
		logger.info("ApplicationBean create");
		count = 0l;
	}

	public ApplicationBean() {
		logger.info("ApplicationBean consturct");
	}

	private Long count;

	public void increase() {
		count += 1;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
