package hu.neuron.java.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class SessionListener
 * 
 */
public class SessionLivecycleListener implements HttpSessionListener {
	private static final Logger logger = LogManager.getLogger(SessionLivecycleListener.class);

	/**
	 * Default constructor.
	 */
	public SessionLivecycleListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		logger.debug("Session: created: " + event.getSession().getId());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.debug("Session: destroyed: " + event.getSession().getId());
	}

}
