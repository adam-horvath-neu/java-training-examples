package hu.neuron.java.webservice;

import hu.neuron.java.webservice.vo.WebServiceTestVo;

public interface EJBWebServiceRemote {

	WebServiceTestVo sendMesage(WebServiceTestVo vo);
}
