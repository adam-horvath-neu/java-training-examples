package hu.neuron.java.webservice.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.WebServiceFeature;

import hu.neuron.java.webservice.imp.EJBWebServiceBean;
import hu.neuron.java.webservice.imp.EJBWebServiceBeanService;
import hu.neuron.java.webservice.imp.WebServiceTestVo;

public class TestCall {

	public static void main(String[] args) {
		URL url=null;
		try {
			url = new URL("http://localhost:8080/ejb-service/EJBWebServiceBean?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		EJBWebServiceBeanService ejbWebServiceBeanService = new EJBWebServiceBeanService(url);

		EJBWebServiceBean ejbWebServiceBean = ejbWebServiceBeanService.getEJBWebServiceBeanPort();

		WebServiceTestVo vo = new WebServiceTestVo();
		vo.setMessage("indul a görög aludni");
		WebServiceTestVo rv = ejbWebServiceBean.sendMesage(vo);
		System.out.println(rv.getMessage());
	}
}
