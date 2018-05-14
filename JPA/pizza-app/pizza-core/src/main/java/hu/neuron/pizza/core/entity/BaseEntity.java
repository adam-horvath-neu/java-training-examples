package hu.neuron.pizza.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String recUser;

	private String modUser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date recDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modDate;

	@Version
	private Long version;

	@PrePersist
	public void prePersist() {
		recDate = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		modDate = new Date();
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecUser() {
		return recUser;
	}

	public void setRecUser(String recUser) {
		this.recUser = recUser;
	}

	public String getModUser() {
		return modUser;
	}

	public void setModUser(String modUser) {
		this.modUser = modUser;
	}

	public Date getRecDate() {
		return recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
