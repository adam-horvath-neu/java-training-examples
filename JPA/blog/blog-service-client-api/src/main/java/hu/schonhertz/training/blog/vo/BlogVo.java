package hu.schonhertz.training.blog.vo;

import java.io.Serializable;
import java.util.Set;

public class BlogVo implements Serializable {

	private static final long serialVersionUID = 6910073404167997813L;

	private Long id;

	private UserVo creator;

	private Set<CommentVo> comments;

	private String title;

	private String text;

	public BlogVo() {
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
	 * @return the creator
	 */
	public UserVo getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(UserVo creator) {
		this.creator = creator;
	}

	/**
	 * @return the comments
	 */
	public Set<CommentVo> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(Set<CommentVo> comments) {
		this.comments = comments;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
