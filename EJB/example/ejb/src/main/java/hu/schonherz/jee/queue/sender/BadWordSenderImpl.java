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
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.jboss.logging.Logger;

import hu.schonherz.jee.queue.BadWordSenderRemote;
import hu.schonherz.jee.queue.vo.BadWordMessageRequest;
import hu.schonherz.jee.queue.vo.BadWordMessageResponse;

@Singleton(mappedName = "BadWordSender", name = "BadWordSender")
@Remote(BadWordSenderRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BadWordSenderImpl implements BadWordSenderRemote {
	private static final Logger logger = Logger.getLogger(BadWordSenderImpl.class);

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/jms/queue/BadWordQueueIn")
	private Queue queueIn;

	@Resource(mappedName = "java:/jms/queue/BadWordQueueOut")
	private Queue queueOut;

	@Override
	public void sendRequest(BadWordMessageRequest message) throws Exception {

		Connection connection = null;
		MessageProducer producer = null;
		Session session = null;
		try {
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			producer = session.createProducer(queueIn);

			ObjectMessage messageOut = session.createObjectMessage();

			messageOut.setObject(message);
			producer.send(messageOut);

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

	@Override
	public void sendResponse(BadWordMessageResponse message) throws Exception {
		Connection connection = null;
		MessageProducer producer = null;
		Session session = null;
		try {
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			producer = session.createProducer(queueOut);

			ObjectMessage messageOut = session.createObjectMessage();

			messageOut.setObject(message);
			producer.send(messageOut);

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
