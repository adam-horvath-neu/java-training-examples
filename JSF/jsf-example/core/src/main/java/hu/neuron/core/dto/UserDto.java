package hu.neuron.core.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String gender;

	private byte[] image;

	public UserDto() {
	}

	public UserDto(Long id, String username, String password, String gender, byte[] image) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
