package hu.schonhertz.training.blog.vo;

import java.io.Serializable;

public class CommentVo implements Serializable {

	private static final long serialVersionUID = -4877641302795620514L;

	private Long id;
	private String comment;

	public CommentVo() {
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

}
