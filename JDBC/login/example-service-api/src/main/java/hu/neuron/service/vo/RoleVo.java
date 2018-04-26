package hu.neuron.service.vo;

import java.io.Serializable;

public class RoleVo implements Serializable {
	private static final long serialVersionUID = -5474224710861447781L;

	private Long id;
	private String name;

	public RoleVo() {
	}

	public RoleVo(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
