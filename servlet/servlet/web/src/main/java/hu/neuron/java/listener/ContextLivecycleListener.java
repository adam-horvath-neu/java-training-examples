package hu.neuron.java.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ContextListener
 * 
 */
@WebListener
public class ContextLivecycleListener implements ServletContextListener {
	private static final Logger logger = LogManager.getLogger(ContextLivecycleListener.class);

	/**
	 * Default constructor.
	 */
	public ContextLivecycleListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		// logger.debug("Context: contextInitialized ContextPath: "
		// + event.getServletContext().getContextPath());

		ServletContext c = event.getServletContext();
		for (Enumeration<String> iterator = c.getInitParameterNames(); iterator.hasMoreElements();) {
			String param = iterator.nextElement();
			logger.debug("Context:" + param + " " + c.getInitParameter(param));
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.debug("Context: contextDestroyed");
	}

}
