package hu.schonherz.jee.queue.reciver.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.queue.vo.BadWordMessageResponse;
import hu.schonherz.jee.timer.SimpleTimer;

/**
 * Message-Driven Bean implementation class for: BadWordRosponseMDB
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/BadWordQueueOut"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })

public class BadWordRosponseMDB implements MessageListener {

	private static Log logger = LogFactory.getLog(BadWordRosponseMDB.class);

	/**
	 * Default constructor.
	 */
	public BadWordRosponseMDB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	@Override
	public void onMessage(Message message) {
		try {
			ObjectMessage objectMessage = (ObjectMessage) message;
			BadWordMessageResponse response;

			response = (BadWordMessageResponse) objectMessage.getObject();
			logger.error("Please, don't use the next word: " + response.getBadWord());

		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
	}

}
