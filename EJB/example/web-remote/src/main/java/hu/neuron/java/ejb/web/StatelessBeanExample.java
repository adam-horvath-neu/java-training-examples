package hu.neuron.java.ejb.web;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.MappedNameStatelessRemote;
import hu.schonherz.jee.NoSerializabledVO;
import hu.schonherz.jee.SerializabledVO;
import hu.schonherz.jee.StatelessRemote;

@Named("statelessBeanExample")
@ViewScoped
public class StatelessBeanExample implements Serializable {

	private static final long serialVersionUID = -2574198067399430161L;

	private static Log logger = LogFactory.getLog(StatelessBeanExample.class);

	@EJB(lookup = "java:global/ear-bus/ejb/StatelessBean!hu.schonherz.jee.StatelessRemote")
	private StatelessRemote statelessRemote;

	@EJB(mappedName = "ejb/NewNameForMappedNameStatelessBean")
	private MappedNameStatelessRemote mappedNameStatelessRemote;

	@PostConstruct
	public void init() {

		Properties prop = new Properties();

		prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
		Context context = null;
		try {
			context = new InitialContext(prop);

			// statelessRemote = (StatelessRemote) context
			// .lookup("ejb:ear-bus/ejb/StatelessBean!hu.schonherz.jee.StatelessRemote");

		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				context.close();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

		a = 0.0;
		b = 0.0;
	}

	private Double a;
	private Double b;

	private String text;

	public void addRemote() {
		a = statelessRemote.add(a, b);
	}

	public void upperCaseSerializabledRemote() {
		SerializabledVO serializabledVO = new SerializabledVO();
		serializabledVO.setText(text);
		text = statelessRemote.upperCase(serializabledVO).getText();
	}

	public void upperCaseNoSerializabledRemote() {
		NoSerializabledVO serializabledVO = new NoSerializabledVO();
		serializabledVO.setText(text);
		text = statelessRemote.upperCase(serializabledVO).getText();
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
