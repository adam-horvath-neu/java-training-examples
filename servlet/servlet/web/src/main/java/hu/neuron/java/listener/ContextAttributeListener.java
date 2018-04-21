package hu.neuron.java.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ContextListener
 * 
 */
@WebListener
public class ContextAttributeListener implements ServletContextAttributeListener {
	private static final Logger logger = LogManager.getLogger(ContextAttributeListener.class);

	/**
	 * Default constructor.
	 */
	public ContextAttributeListener() {
		// TODO Auto-generated constructor stub
	}

	public void attributeAdded(ServletContextAttributeEvent event) {
		logger.debug("Context attributeAdded " + event.getName() + " " + event.getValue());

	}

	public void attributeRemoved(ServletContextAttributeEvent event) {
		logger.debug("Context attributeRemoved " + event.getName() + " " + event.getValue());

	}

	public void attributeReplaced(ServletContextAttributeEvent event) {
		logger.debug("Context attributeReplaced " + event.getName() + " " + event.getValue());

	}

}
