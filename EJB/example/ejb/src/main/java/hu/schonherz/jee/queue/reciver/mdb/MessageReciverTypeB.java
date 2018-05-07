package hu.schonherz.jee.queue.reciver.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

/**
 * Message-Driven Bean implementation class for: MessageSubscriberA1
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Queue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "TYPE = 'B'") })
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MessageReciverTypeB implements MessageListener {
	private static final Logger logger = Logger.getLogger(MessageReciverTypeB.class);

	@Resource
	private MessageDrivenContext mdc;

	/**
	 * Default constructor.
	 */

	public MessageReciverTypeB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	@Override
	public void onMessage(Message inMessage) {
		TextMessage msg = null;

		try {
			if (inMessage instanceof TextMessage) {
				msg = (TextMessage) inMessage;
				logger.info("MESSAGE BEAN: Message received: " + msg.getObjectProperty("TYPE") + " " + msg.getText());
			} else {
				logger.warn("Message of wrong type: " + inMessage.getClass().getName());
			}
		} catch (JMSException e) {
			e.printStackTrace();
			mdc.setRollbackOnly();
		} catch (Throwable te) {
			te.printStackTrace();
		}
	}

}
