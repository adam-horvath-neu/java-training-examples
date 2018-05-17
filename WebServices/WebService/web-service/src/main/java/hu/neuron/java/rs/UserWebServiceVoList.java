package hu.neuron.java.rs;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserVoList")
public class UserWebServiceVoList implements Serializable {

	private List<UserWebServiceVo> userWebServiceVos;

	
	
	public UserWebServiceVoList() {
	}

	public UserWebServiceVoList(List<UserWebServiceVo> userWebServiceVos) {
		super();
		this.userWebServiceVos = userWebServiceVos;
	}



	public List<UserWebServiceVo> getUserWebServiceVos() {
		return userWebServiceVos;
	}

	public void setUserWebServiceVos(List<UserWebServiceVo> userWebServiceVos) {
		this.userWebServiceVos = userWebServiceVos;
	}
}
