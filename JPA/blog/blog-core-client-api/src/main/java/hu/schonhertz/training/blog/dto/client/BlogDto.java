package hu.schonhertz.training.blog.dto.client;

import java.io.Serializable;
import java.util.Set;

public class BlogDto implements Serializable {

	private static final long serialVersionUID = 9059507249101106233L;

	private Long id;

	private UserDto creator;

	private Set<CommentDto> comments;

	private String title;

	private String text;

	public BlogDto() {
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
	 * @return the creator
	 */
	public UserDto getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(UserDto creator) {
		this.creator = creator;
	}

	/**
	 * @return the comments
	 */
	public Set<CommentDto> getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(Set<CommentDto> comments) {
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

	@Override
	public String toString() {
		return "Blog [id=" + id + ", creator=" + creator + ", title=" + title + ", text=" + text + "]";
	}

}
