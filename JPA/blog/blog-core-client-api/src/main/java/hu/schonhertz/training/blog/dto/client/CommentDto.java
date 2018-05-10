package hu.schonhertz.training.blog.dto.client;

import java.io.Serializable;

public class CommentDto implements Serializable {

	private static final long serialVersionUID = 8899131570615506546L;

	private Long id;
	private String comment;

	public CommentDto() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", comment=" + comment + "]";
	}

}
