package hu.schonherz.jee.queue.sender;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

import hu.schonherz.jee.queue.MessageSenderSyncRemote;

@Singleton(mappedName = "MessageSenderSync", name = "MessageSenderSync")
@Remote(MessageSenderSyncRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MessageSenderSync implements MessageSenderSyncRemote {
	private static final Logger logger = Logger.getLogger(MessageSenderSyncRemote.class);

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/jms/queue/QueueSync")
	private Queue queue;

	@Override
	public void send(String message) throws Exception {

		Connection connection = null;
		MessageProducer producer = null;
		Session session = null;
		try {
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			producer = session.createProducer(queue);

			TextMessage messageOut = session.createTextMessage();

			messageOut.setText(message);

			producer.send(messageOut);
			logger.info("Messeage send:" + message);
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			try {
				session.close();
			} catch (JMSException e1) {
				logger.error(e1.getMessage(), e1);
			}
			try {
				producer.close();
			} catch (JMSException e2) {
				logger.error(e2.getMessage(), e2);
			}
			try {
				connection.close();
			} catch (JMSException e3) {
				logger.error(e3.getMessage(), e3);
			}
		}

	}
}
