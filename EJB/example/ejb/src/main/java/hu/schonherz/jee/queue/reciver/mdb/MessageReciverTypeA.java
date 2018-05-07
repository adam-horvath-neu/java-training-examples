package hu.schonherz.jee.queue.reciver.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.queue.BadWordSenderRemote;
import hu.schonherz.jee.queue.vo.BadWordMessageRequest;

/**
 * Message-Driven Bean implementation class for: MessageSubscriberA1
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/Queue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "TYPE = 'A'") })
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MessageReciverTypeA implements MessageListener {
	private static Log logger = LogFactory.getLog(MessageReciverTypeA.class);

	@Resource
	private MessageDrivenContext mdc;

	@EJB
	BadWordSenderRemote badWordSenderRemote;

	/**
	 * Default constructor.
	 */

	public MessageReciverTypeA() {
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
				BadWordMessageRequest message = new BadWordMessageRequest();
				message.setMessages(msg.getText());
				badWordSenderRemote.sendRequest(message);
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
