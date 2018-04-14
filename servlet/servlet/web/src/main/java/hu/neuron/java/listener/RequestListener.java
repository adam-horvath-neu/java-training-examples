package hu.neuron.java.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class servlet
 * 
 */
@WebListener
public class RequestListener implements ServletRequestListener {
	private static final Logger logger = LogManager.getLogger(RequestListener.class);

	/**
	 * Default constructor.
	 */
	public RequestListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		logger.debug("Request: requestDestroyed: " + ((HttpServletRequest) event.getServletRequest()).getRequestURL());
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent event) {
		logger.debug(
				"Request: requestInitialized: " + ((HttpServletRequest) event.getServletRequest()).getRequestURL());
	}

}
