package hu.neuron.java.ws.impl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.neuron.java.ws.WebServiceExample;

@WebService(endpointInterface = "hu.neuron.java.ws.WebServiceExample")
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
public class WebServiceExampleImpl implements WebServiceExample {
	private static Log logger = LogFactory.getLog(WebServiceExampleImpl.class);

	public String echo(String message) {
		logger.info(message);
		return "WebServiceExample: " + message;
	}
}
