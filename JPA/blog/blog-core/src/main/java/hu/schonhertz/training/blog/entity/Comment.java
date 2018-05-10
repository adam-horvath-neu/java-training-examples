package hu.schonhertz.training.blog.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * The Class User.
 */
@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Lob
	private String comment;


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
