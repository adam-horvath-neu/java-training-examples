package hu.neuron.java.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

import generated.UserWebServiceVo;
import hu.neuron.java.ws.impl.WebServiceExample;
import hu.neuron.java.ws.impl.WebServiceExampleImplService;

@ManagedBean(name = "serviceTestBean")
@SessionScoped
public class ServiceTestBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@WebServiceRef(value = WebServiceExampleImplService.class)
	private WebServiceExample port;

	private String message;

	private String echo;

	private UserWebServiceVo userWebServiceVo;

	public void test() {

		WebServiceExampleImplService exampleImplService = new WebServiceExampleImplService();

		WebServiceExample exampleImpl = exampleImplService.getWebServiceExampleImplPort();

		echo = exampleImpl.echo(message);
	}

	public void testRef() {

		echo = port.echo(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEcho() {
		return echo;
	}

	public void setEcho(String echo) {
		this.echo = echo;
	}

	public UserWebServiceVo getUserWebServiceVo() {
		return userWebServiceVo;
	}

	public void setUserWebServiceVo(UserWebServiceVo userWebServiceVo) {
		this.userWebServiceVo = userWebServiceVo;
	}
}
