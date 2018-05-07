package hu.schonherz.jee.queue;

public interface MessageReciverSyncRemote {

	String consum() throws Exception;

	Integer browse() throws Exception;
}
