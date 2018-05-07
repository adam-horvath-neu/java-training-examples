package hu.schonherz.jee.queue.vo;

import java.io.Serializable;

public class BadWordMessageResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long targetUserId;
	private String badWord;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBadWord() {
		return badWord;
	}

	public void setBadWord(String badWord) {
		this.badWord = badWord;
	}

	public Long getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Long targetUserId) {
		this.targetUserId = targetUserId;
	}

}
