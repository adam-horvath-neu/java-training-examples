package hu.neuron.java.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class servlet
 * 
 */
@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {
	private static final Logger logger = LogManager.getLogger(RequestAttributeListener.class);

	/**
	 * Default constructor.
	 */
	public RequestAttributeListener() {
		// TODO Auto-generated constructor stub
	}

	public void attributeAdded(ServletRequestAttributeEvent event) {
		logger.debug("Request attributeAdded " + ((HttpServletRequest) event.getServletRequest()).getRequestURL() + " "
				+ event.getName() + " " + event.getValue());
	}

	public void attributeRemoved(ServletRequestAttributeEvent event) {
		logger.debug("Request attributeRemoved " + ((HttpServletRequest) event.getServletRequest()).getRequestURL()
				+ " " + event.getName() + " " + event.getValue());

	}

	public void attributeReplaced(ServletRequestAttributeEvent event) {
		logger.debug("Request attributeReplaced " + ((HttpServletRequest) event.getServletRequest()).getRequestURL()
				+ " " + event.getName() + " " + event.getValue());

	}

}
