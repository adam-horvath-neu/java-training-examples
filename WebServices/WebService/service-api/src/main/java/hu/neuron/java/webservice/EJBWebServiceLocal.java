package hu.neuron.java.webservice;

import hu.neuron.java.webservice.vo.WebServiceTestVo;

public interface EJBWebServiceLocal {

	WebServiceTestVo sendMesage(WebServiceTestVo vo);
}
