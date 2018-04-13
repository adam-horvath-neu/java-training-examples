package hu.neuron.java.simple;

import java.io.Serializable;
import java.util.Date;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Date date;
	private String name;
	private String role;

	public Data() {
	}

	public Data(Long id, Date date, String name, String role) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.role = role;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
