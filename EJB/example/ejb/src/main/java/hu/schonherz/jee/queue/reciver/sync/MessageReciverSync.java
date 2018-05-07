package hu.schonherz.jee.queue.reciver.sync;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

import hu.schonherz.jee.queue.MessageReciverSyncRemote;

@Singleton(name = "MessageReciverSync", mappedName = "MessageReciverSync")
@Remote(MessageReciverSyncRemote.class)
public class MessageReciverSync implements MessageReciverSyncRemote {
	private static final Logger logger = Logger.getLogger(MessageReciverSync.class);

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/jms/queue/QueueSync")
	private Queue queue;

	@Override
	public String consum() throws Exception {

		QueueConnection connection = null;
		QueueReceiver receiver = null;
		QueueSession session = null;
		String message = null;
		try {
			connection = ((QueueConnectionFactory) connectionFactory).createQueueConnection();
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

			receiver = session.createReceiver(queue);

			connection.start();
			TextMessage textMessage = (TextMessage) receiver.receive(300);
			if (textMessage != null) {
				message = textMessage.getText();
				logger.info(message);
			}

		} finally {
			try {
				session.close();
			} catch (JMSException e1) {
				logger.error(e1.getMessage(), e1);
			}
			try {
				receiver.close();
			} catch (JMSException e2) {
				logger.error(e2.getMessage(), e2);
			}
			try {
				connection.close();
			} catch (JMSException e3) {
				logger.error(e3.getMessage(), e3);
			}
		}
		return message;

	}

	@Override
	public Integer browse() throws Exception {

		QueueConnection connection = null;
		QueueBrowser queueBrowser = null;
		QueueSession session = null;
		Integer count = 0;
		try {
			connection = ((QueueConnectionFactory) connectionFactory).createQueueConnection();
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

			queueBrowser = session.createBrowser(queue);

			connection.start();
			Enumeration e = queueBrowser.getEnumeration();
			// count number of messages
			while (e.hasMoreElements()) {
				Message message = (Message) e.nextElement();
				count++;
			}

			logger.debug(queue + " has " + count + " messages");
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);

		} finally {
			try {
				session.close();
			} catch (JMSException e1) {
				logger.error(e1.getMessage(), e1);
			}
			try {
				queueBrowser.close();
			} catch (JMSException e2) {
				logger.error(e2.getMessage(), e2);
			}
			try {
				connection.close();
			} catch (JMSException e3) {
				logger.error(e3.getMessage(), e3);
			}
		}
		return count;

	}

}
