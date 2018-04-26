package hu.neuron.service.vo;

import java.io.Serializable;
import java.util.List;

public class UserVo implements Serializable {
	private static final long serialVersionUID = 6059096016587583729L;

	private Long id;
	private String username;
	private String password;
	private List<RoleVo> roles;

	public UserVo() {
	}

	public UserVo(Long id, String username, String password, List<RoleVo> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
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

	public List<RoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVo> roles) {
		this.roles = roles;
	}

}
