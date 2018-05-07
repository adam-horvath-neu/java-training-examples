package hu.schonherz.jee.queue;

public interface MessageSenderRemote {

	public void send(String message, MessageType type) throws Exception;
}
