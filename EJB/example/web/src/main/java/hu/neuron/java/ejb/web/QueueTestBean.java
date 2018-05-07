package hu.neuron.java.ejb.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.queue.MessageReciverSyncRemote;
import hu.schonherz.jee.queue.MessageSenderRemote;
import hu.schonherz.jee.queue.MessageSenderSyncRemote;
import hu.schonherz.jee.queue.MessageType;

@ManagedBean(name = "queueTestBean")
@ViewScoped
public class QueueTestBean implements Serializable {

	private static final long serialVersionUID = 4560143022304816433L;

	private static Log logger = LogFactory.getLog(QueueTestBean.class);

	@EJB
	MessageSenderSyncRemote messageSenderSyncRemote;

	@EJB
	MessageSenderRemote messageSenderRemote;

	@EJB
	MessageReciverSyncRemote messageReciverSyncRemote;

	private String message;

	private String responseMessage;

	public void sendMessageTypeA() {
		try {
			messageSenderRemote.send(message, MessageType.A);
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
	}

	public void sendMessageTypeB() {
		try {
			messageSenderRemote.send(message, MessageType.B);
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
	}

	public void sendMessageSync() {
		try {
			messageSenderSyncRemote.send(message);
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
	}

	public Integer getMessageCount() {
		try {
			return messageReciverSyncRemote.browse();
		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
		return null;

	}

	public void read() {
		try {
			responseMessage = messageReciverSyncRemote.consum();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public MessageSenderSyncRemote getMessageSenderSyncRemote() {
		return messageSenderSyncRemote;
	}

	public void setMessageSenderSyncRemote(MessageSenderSyncRemote messageSenderSyncRemote) {
		this.messageSenderSyncRemote = messageSenderSyncRemote;
	}

	public MessageSenderRemote getMessageSenderRemote() {
		return messageSenderRemote;
	}

	public void setMessageSenderRemote(MessageSenderRemote messageSenderRemote) {
		this.messageSenderRemote = messageSenderRemote;
	}

	public MessageReciverSyncRemote getMessageReciverSyncRemote() {
		return messageReciverSyncRemote;
	}

	public void setMessageReciverSyncRemote(MessageReciverSyncRemote messageReciverSyncRemote) {
		this.messageReciverSyncRemote = messageReciverSyncRemote;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
