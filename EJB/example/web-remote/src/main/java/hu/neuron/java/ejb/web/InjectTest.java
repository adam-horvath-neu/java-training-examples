package hu.neuron.java.ejb.web;

import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import hu.schonherz.jee.StatelessRemote;

@Singleton
@LocalBean
@EJBs({ @EJB(name = "injected/Test",  beanInterface = StatelessRemote.class) })
public class InjectTest {
	@EJB(name = "java:comp/env/injected/Test")
	private StatelessRemote statelessRemote;

	public void hello() {
		statelessRemote.hello();
	}

	public Double add(Double a, Double b) {
		return statelessRemote.add(a, b);
	}

}
