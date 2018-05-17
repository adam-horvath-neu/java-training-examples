package hu.neuron.java.webservice.imp;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import hu.neuron.java.webservice.EJBWebServiceLocal;
import hu.neuron.java.webservice.EJBWebServiceRemote;
import hu.neuron.java.webservice.vo.WebServiceTestVo;

@Stateless
@Local(EJBWebServiceLocal.class)
@Remote(EJBWebServiceRemote.class)
@WebService
public class EJBWebServiceBean implements EJBWebServiceLocal, EJBWebServiceRemote {

	@Override
	@WebMethod(operationName="sendMesage")
	@WebResult(name="result")
	public WebServiceTestVo sendMesage(@WebParam(name="vo") WebServiceTestVo vo) {
		WebServiceTestVo serviceTestVo = new WebServiceTestVo();
		String string = new StringBuilder(vo.getMessage()).reverse().toString();
		serviceTestVo.setMessage(string);
		return serviceTestVo;
	}

}
