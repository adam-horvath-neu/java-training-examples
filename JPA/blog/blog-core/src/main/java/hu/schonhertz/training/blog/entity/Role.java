package hu.schonhertz.training.blog.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class of Role.
 */
@Entity
@Table(name = "Role")
@NamedQueries({
		@NamedQuery(name = "findRolesByUserId", query = "select roles from User u join u.roles roles where u.id=:pUserId"),
		@NamedQuery(name = "findRoleByName", query = "select r from Role r where r.name=:pName") })
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
