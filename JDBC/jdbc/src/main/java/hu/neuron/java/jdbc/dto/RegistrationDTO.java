package hu.neuron.java.jdbc.dto;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {

	private static final long serialVersionUID = 246548009510456843L;

	private Long id;
	private String lastName;
	private String firstName;
	private Integer age;

	public RegistrationDTO() {
	}

	public RegistrationDTO(Long id, String lastName, String firstName,
			Integer age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
