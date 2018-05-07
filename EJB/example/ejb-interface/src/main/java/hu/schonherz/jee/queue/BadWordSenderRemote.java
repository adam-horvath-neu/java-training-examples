package hu.schonherz.jee.queue;

import hu.schonherz.jee.queue.vo.BadWordMessageRequest;
import hu.schonherz.jee.queue.vo.BadWordMessageResponse;

public interface BadWordSenderRemote {

	public void sendRequest(BadWordMessageRequest message) throws Exception;

	public void sendResponse(BadWordMessageResponse message) throws Exception;
}
